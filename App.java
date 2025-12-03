/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* App Demonstration
***********************/

// App.java
public class App {
    public static void main(String[] args) {
        System.out.println("=== Project Week 4 ===");
        System.out.println("Assignment: SQLite CRUD Operations");
        System.out.println("Student: Tony Boyle Jr\n");

        // Ensure the database table is created
        DatabaseHelper.createTable();

        // Create instances of contacts
        BusinessContact b1 = new BusinessContact("Sarah", 
        "Kent", 
        "555-1000", 
        "s.kent@corp.com", 
        "Kent Corp", 
        "Manager");
        
        FamilyContact f1 = new FamilyContact("Mike", 
        "Andrews", 
        "555-2222", 
        "m.andrews@email.com", 
        "Cousin");

        FriendContact fr1 = new FriendContact("Lily", 
        "Mason", 
        "555-3333", 
        "lily@gmail.com", 
        "Lil", 
        "Met at college");

        // Create an instance of Rolodex and add contacts
        Rolodex rolodex = new Rolodex();
        rolodex.addContact(b1);
        rolodex.addContact(f1);
        rolodex.addContact(fr1);

        // Display all contacts from the database
        System.out.println("Displaying all contacts:\n");
        rolodex.displayAllContacts();

        // Update a contact's phone number
        System.out.println("Updating Lily's phone number...\n");
        rolodex.addContact(fr1);
        rolodex.displayAllContacts();
    }
}