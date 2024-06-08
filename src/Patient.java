import java.io.Serializable;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L; // Add serialVersionUID for Serializable
    private String firstName;
    private String lastName;
    private String bloodGroup;
    private String email;
    private String passWord;

    public Patient(String firstName, String lastName, String email, String passWord) {
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassWord(passWord);
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
