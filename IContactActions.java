/******************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Purpose: Interface for updating and summarizing contacts. 
 *********************/ 

public interface IContactActions { 

    void updateContact(String field, String newValue); 

    String getSummary(); 

} 