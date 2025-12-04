/*************************
 * Tony Boyle Jr
 * 12/3/2025
 * DatabaseHelper.java
 ************************/

import java.sql.*;

public class DatabaseHelper {

    private static final String DATABASE_URL = "jdbc:sqlite:rolodex.db";  // SQLite database file path

    // Method to establish a connection to the SQLite database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    // Method to create the contacts table if it doesn't already exist
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS contacts ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "first_name TEXT, "
                + "last_name TEXT, "
                + "phone TEXT, "
                + "email TEXT, "
                + "type TEXT, "
                + "company TEXT, "
                + "job_title TEXT, "
                + "relationship TEXT, "
                + "nickname TEXT, "
                + "how_we_met TEXT"
                + ");";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a contact to the database (Create)
    public static void addContact(Contact contact) {
        String insertSQL = "INSERT INTO contacts(first_name, last_name, phone, email, type, company, job_title, relationship, nickname, how_we_met) "
                         + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, contact.firstName);
            pstmt.setString(2, contact.lastName);
            pstmt.setString(3, contact.phoneNumber);
            pstmt.setString(4, contact.email);

            // Set additional fields based on contact type
            if (contact instanceof BusinessContact) {
                pstmt.setString(5, "Business");
                pstmt.setString(6, ((BusinessContact) contact).getCompanyName());
                pstmt.setString(7, ((BusinessContact) contact).getJobTitle());
            } else if (contact instanceof FamilyContact) {
                pstmt.setString(5, "Family");
                pstmt.setString(6, ((FamilyContact) contact).getRelationship());
                pstmt.setString(7, "");
            } else if (contact instanceof FriendContact) {
                pstmt.setString(5, "Friend");
                pstmt.setString(6, ((FriendContact) contact).getNickname());
                pstmt.setString(7, ((FriendContact) contact).getHowWeMet());
            }

            pstmt.setString(8, ""); // Placeholder for relationship
            pstmt.setString(9, ""); // Placeholder for nickname
            pstmt.setString(10, ""); // Placeholder for how_we_met
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all contacts (Read)
    public static void displayAllContacts() {
        String selectSQL = "SELECT * FROM contacts";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String type = rs.getString("type");

                System.out.println(type + " Contact: " + firstName + " " + lastName);
                System.out.println("Phone: " + phone);
                System.out.println("Email: " + email);
                System.out.println("==================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a contact's field (Update)
    public static void updateContact(int id, String field, String newValue) {
        String updateSQL = "UPDATE contacts SET " + field + " = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, newValue);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a contact from the database (Delete)
    public static void deleteContact(int id) {
        String deleteSQL = "DELETE FROM contacts WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}