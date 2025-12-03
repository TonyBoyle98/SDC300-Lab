/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* Contact Class 
***********************/

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

    // Abstract method to display contact information
    public abstract void displayContact();

    // Implement updateContact method from IContactActions interface
    @Override
    public void updateContact(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "firstname": 
                this.firstName = newValue; 
                break;
            case "lastname": 
                this.lastName = newValue; 
                break;
            case "phone": 
                this.phoneNumber = newValue; 
                break;
            case "email": 
                this.email = newValue; 
                break;
            default:
                System.out.println("Invalid field.");
        }
    }

    // Implement getSummary method from IContactActions interface
    @Override
    public String getSummary() {
        return lastName + ", " + firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }
}