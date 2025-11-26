/******************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Family Contact Class 
 *********************/ 

public class FamilyContact extends Contact { 
    private String relationship; 

    public FamilyContact(String firstName, String lastName, String phone, String email, 
        String relationship) { 
        super(firstName, lastName, phone, email); 
        this.relationship = relationship; 
    } 

 
    @Override 
    public void displayContact() { 
        System.out.println("=== Family Contact ==="); 
        System.out.println("Name: " + firstName + " " + lastName); 
        System.out.println("Relationship: " + relationship); 
        System.out.println("Phone: " + phoneNumber); 
        System.out.println("Email: " + email); 

    } 
} 