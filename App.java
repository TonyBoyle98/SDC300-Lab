/*************************
 * Tony Boyle Jr
 * 12/3/2025
 * App.java
 ************************/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Project Week 4 ===");
        System.out.println("Assignment: SQLite CRUD Operations");
        System.out.println("Student: Tony Boyle Jr\n");

        // Ensure the database table is created
        DatabaseHelper.createTable();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a new contact
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.println("Contact Type (Business, Family, Friend): ");
                    String type = scanner.nextLine();

                    if (type.equalsIgnoreCase("Business")) {
                        System.out.print("Enter company name: ");
                        String company = scanner.nextLine();
                        System.out.print("Enter job title: ");
                        String jobTitle = scanner.nextLine();
                        BusinessContact businessContact = new BusinessContact(firstName, lastName, phone, email, company, jobTitle);
                        DatabaseHelper.addContact(businessContact);
                    } else if (type.equalsIgnoreCase("Family")) {
                        System.out.print("Enter relationship: ");
                        String relationship = scanner.nextLine();
                        FamilyContact familyContact = new FamilyContact(firstName, lastName, phone, email, relationship);
                        DatabaseHelper.addContact(familyContact);
                    } else if (type.equalsIgnoreCase("Friend")) {
                        System.out.print("Enter nickname: ");
                        String nickname = scanner.nextLine();
                        System.out.print("How did you meet? ");
                        String howWeMet = scanner.nextLine();
                        FriendContact friendContact = new FriendContact(firstName, lastName, phone, email, nickname, howWeMet);
                        DatabaseHelper.addContact(friendContact);
                    }
                    break;
                case 2:
                    // Display all contacts
                    DatabaseHelper.displayAllContacts();
                    break;
                case 3:
                    // Update a contact
                    System.out.print("Enter contact ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter field to update (first_name, last_name, phone, email): ");
                    String field = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    DatabaseHelper.updateContact(updateId, field, newValue);
                    break;
                case 4:
                    // Delete a contact
                    System.out.print("Enter contact ID to delete: ");
                    int deleteId = scanner.nextInt();
                    DatabaseHelper.deleteContact(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}