/**************************** 
* Tony Boyle Jr 
* 12/2/2025 
* FriendContact Class 
***********************/

public class FriendContact extends Contact {
    private String nickname;
    private String howWeMet;

    // Constructor
    public FriendContact(String firstName, 
        String lastName, 
        String phone, 
        String email, 
        String nickname, 
        String howWeMet) {
        super(firstName, lastName, phone, email);
        this.nickname = nickname;
        this.howWeMet = howWeMet;
    }

    @Override
    public void displayContact() {
        System.out.println("=== Friend Contact ===");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Nickname: " + nickname);
        System.out.println("How We Met: " + howWeMet);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    // Implement getNickname method
    public String getNickname() {
        return nickname;
    }

    // Implement getHowWeMet method
    public String getHowWeMet() {
        return howWeMet;
    }
}