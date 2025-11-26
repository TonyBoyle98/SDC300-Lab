/******************** 
 * Name: Tony Boyle Jr 
 * Date: 11/25/2025 
 * Assignment: Rolodex  
 *******************/ 

import java.util.ArrayList; 

public class Rolodex { 
    private ArrayList<Contact> contacts = new ArrayList<>(); 
    public void addContact(Contact c) { 
        contacts.add(c); 
    } 

    public void displayAllContacts() { 
        for (Contact c : contacts) { 
            c.displayContact(); 
            System.out.println("------------------------"); 
        } 
    } 

    public void displayContactsByLetter(char letter) { 
        for (Contact c : contacts) { 
        if (c.getLastName().toUpperCase().charAt(0) == Character.
        toUpperCase(letter)) { 
        c.displayContact(); 
        System.out.println("------------------------"); 

         } 

        } 

    } 

} 