/*************************
 * Tony Boyle Jr
 * 12/3/2025
 * Rolodex.java
 ************************/

import java.util.ArrayList;

public class Rolodex {
    private ArrayList<Contact> contacts;

    public Rolodex() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added!");
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the Rolodex.");
        } else {
            for (Contact contact : contacts) {
                contact.displayContact();
            }
        }
    }
}