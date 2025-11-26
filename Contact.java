/******************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Contact Class 
 *********************/ 

public abstract class Contact implements IContactActions { 
    protected String firstName; 
    protected String lastName; 
    protected String phoneNumber; 
    protected String email; 

    // Default constructor 
    public Contact() { 
        this.firstName = ""; 
        this.lastName = ""; 
        this.phoneNumber = ""; 
        this.email = ""; 
    } 

    // Main constructor 
    public Contact(String firstName, String lastName, String phone, String email) { 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.phoneNumber = phone; 
        this.email = email; 
    } 

    // Copy constructor 
    public Contact(Contact other) { 
        this.firstName = other.firstName; 
        this.lastName = other.lastName; 
        this.phoneNumber = other.phoneNumber; 
        this.email = other.email; 
    } 

    // ABSTRACT METHOD – required for Week 3 
    public abstract void displayContact(); 

    // Interface method implementation 
    @Override 
    public void updateContact(String field, String newValue) { 
        switch (field.toLowerCase()) { 
            case "firstname": this.firstName = newValue; break; 
            case "lastname": this.lastName = newValue; break; 
            case "phone": this.phoneNumber = newValue; break; 
            case "email": this.email = newValue; break; 
            default: 
            System.out.println("Invalid field."); 
        } 
    } 

    @Override 
    public String getSummary() { 
        return lastName + ", " + firstName; 
    } 
    public String getLastName() { return lastName; } 

} 