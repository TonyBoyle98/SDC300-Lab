/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* BusinessContact Class 
***********************/

import java.sql.*;

public class DatabaseHelper {

    private static final String DATABASE_URL = "jdbc:sqlite:rolodex.db";  
    // SQLite database file path

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
}