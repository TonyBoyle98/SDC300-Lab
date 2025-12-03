/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* Rolodex Class 
***********************/

// Rolodex.java
import java.sql.*;

public class Rolodex {

    // Add a contact to the database
    public void addContact(Contact c) {
        String insertSQL = 
        "INSERT INTO contacts (first_name, last_name, phone, email, type, company, job_title, relationship, nickname, how_we_met) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, c.firstName);
            pstmt.setString(2, c.lastName);
            pstmt.setString(3, c.phoneNumber);
            pstmt.setString(4, c.email);
            pstmt.setString(5, c.getClass().getSimpleName());  // Store the contact type
            if (c instanceof BusinessContact) {
                pstmt.setString(6, ((BusinessContact) c).companyName);
                pstmt.setString(7, ((BusinessContact) c).getJobTitle());
            } else {
                pstmt.setString(6, "");
                pstmt.setString(7, "");
            }
            if (c instanceof FamilyContact) {
                pstmt.setString(8, ((FamilyContact) c).getRelationship());
            } else {
                pstmt.setString(8, "");
            }
            if (c instanceof FriendContact) {
                pstmt.setString(9, ((FriendContact) c).getNickname());
                pstmt.setString(10, ((FriendContact) c).getHowWeMet());
            } else {
                pstmt.setString(9, "");
                pstmt.setString(10, "");
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all contacts from the database
    public void displayAllContacts() {
        String selectSQL = "SELECT * FROM contacts";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                String type = rs.getString("type");
                if ("BusinessContact".equals(type)) {
                    System.out.println("=== Business Contact ===");
                    System.out.println("Name: " + firstName + " " + lastName);
                    System.out.println("Phone: " + phone);
                    System.out.println("Email: " + email);
                    System.out.println("Company: " + rs.
                    getString("company"));
                    System.out.println("Job Title: " + rs.
                    getString("job_title"));
                } else if ("FamilyContact".equals(type)) {
                    System.out.println("=== Family Contact ===");
                    System.out.println("Name: " + firstName + " " + lastName);
                    System.out.println("Phone: " + phone);
                    System.out.println("Email: " + email);
                    System.out.println("Relationship: " + rs.getString(
                    "relationship"));
                } else if ("FriendContact".equals(type)) {
                    System.out.println("=== Friend Contact ===");
                    System.out.println("Name: " + firstName + " " + lastName);
                    System.out.println("Phone: " + phone);
                    System.out.println("Email: " + email);
                    System.out.println("Nickname: " + rs.getString(
                    "nickname"));
                    System.out.println("How We Met: " + rs.
                    getString("how_we_met"));
                }
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}