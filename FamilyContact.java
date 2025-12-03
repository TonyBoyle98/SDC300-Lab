/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* FamilyContact Class 
***********************/

// FamilyContact.java
public class FamilyContact extends Contact {
    private String relationship;

    // Constructor: calls the parent (Contact) constructor
    public FamilyContact(String firstName, String lastName, String phone, String email, String relationship) {
        super(firstName, lastName, phone, email);
        this.relationship = relationship;
    }

    @Override
    public void displayContact() {
        System.out.println("=== Family Contact ===");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Relationship: " + relationship);
    }

    // Getter method
    public String getRelationship() {
        return relationship;
    }
}