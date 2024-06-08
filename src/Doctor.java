import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String licenseNumber;
    private List<String> hospitals;
    private List<String> schedules;

    public Doctor(String firstName, String lastName, String email, String password, String licenseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.hospitals = new ArrayList<>();
        this.schedules = new ArrayList<>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<String> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<String> hospitals) {
        this.hospitals = hospitals;
    }

    public List<String> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }
}
