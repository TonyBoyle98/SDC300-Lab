/******************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Business Contact Class 
 *********************/ 

public class BusinessContact extends Contact { 

    private String companyName; 
    private String jobTitle; 

 

    // Main constructor 
    public BusinessContact(String firstName, String lastName, String phone, String email, 

        String company, String jobTitle) { 

        super(firstName, lastName, phone, email); 

        this.companyName = company; 

        this.jobTitle = jobTitle; 

    } 

 

    // Overloaded constructor 

    public BusinessContact(String firstName, String lastName) { 

        super(firstName, lastName, "", ""); 

        this.companyName = "Unknown"; 

        this.jobTitle = "Unknown"; 

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

} 