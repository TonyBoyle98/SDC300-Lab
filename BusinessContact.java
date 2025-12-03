/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* BusinessContact Class 
***********************/

// BusinessContact.java
public class BusinessContact extends Contact {
    String companyName;
    private String jobTitle;

    // Constructor: calls the parent (Contact) constructor
    public BusinessContact(String firstName, 
        String lastName, 
        String phone, 
        String email, 
        String company, 
        String jobTitle) {
        super(firstName, lastName, phone, email);
        this.companyName = company;
        this.jobTitle = jobTitle;
    }

    @Override
    public void displayContact() {
        System.out.println("=== Business Contact ===");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Company: " + companyName);
        System.out.println("Job Title: " + jobTitle);
    }

    // Getter methods
    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}