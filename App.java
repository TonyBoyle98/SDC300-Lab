/**************************************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Main Program – Week 3 Demonstration 
 *********************/ 

public class App { 

    public static void main(String[] args) { 

        System.out.println("=== Project Week 3 ==="); 
        System.out.println("Assignment: Abstraction, Constructors, Access Specifiers"); 
        System.out.println("Student: Tony Boyle Jr\n"); 
        System.out.println( "Welcome! This application demonstrates abstract classes, constructors, and access control.\n"); 
        Rolodex rolodex = new Rolodex(); 

        // Create contacts using constructors 
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

        // Add to Rolodex 
        rolodex.addContact(b1); 
        rolodex.addContact(f1); 
        rolodex.addContact(fr1); 

        // Display 
        System.out.println("Displaying all contacts:\n"); 
        rolodex.displayAllContacts(); 

        // Demonstrate abstraction + polymorphism 
        System.out.println("Updating Lily's phone number...\n"); 
        fr1.updateContact("phone", "555-9999"); 
        System.out.println("Contacts after update:\n"); 
        rolodex.displayAllContacts(); 
        System.out.println("Contacts with last name starting with 'M':\n"); 
        rolodex.displayContactsByLetter('M'); 

    } 

} 