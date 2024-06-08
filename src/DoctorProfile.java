import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DoctorProfile extends JFrame {
    private Doctor doctor;
    private List<Doctor> doctors;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField licenseNumberField;
    private JTextArea hospitalsArea;
    private JTextArea schedulesArea;

    public DoctorProfile(Doctor doctor) {
        this.doctor = doctor;

        setTitle("Doctor Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(10, 10, 100, 20);
        getContentPane().add(lblFirstName);

        firstNameField = new JTextField(doctor.getFirstName());
        firstNameField.setBounds(120, 10, 200, 20);
        getContentPane().add(firstNameField);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(10, 40, 100, 20);
        getContentPane().add(lblLastName);

        lastNameField = new JTextField(doctor.getLastName());
        lastNameField.setBounds(120, 40, 200, 20);
        getContentPane().add(lastNameField);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 70, 100, 20);
        getContentPane().add(lblEmail);

        emailField = new JTextField(doctor.getEmail());
        emailField.setBounds(120, 70, 200, 20);
        getContentPane().add(emailField);

        JLabel lblLicenseNumber = new JLabel("License Number:");
        lblLicenseNumber.setBounds(10, 100, 100, 20);
        getContentPane().add(lblLicenseNumber);

        licenseNumberField = new JTextField(doctor.getLicenseNumber());
        licenseNumberField.setBounds(120, 100, 200, 20);
        getContentPane().add(licenseNumberField);

        JLabel lblHospitals = new JLabel("Hospitals:");
        lblHospitals.setBounds(10, 130, 100, 20);
        getContentPane().add(lblHospitals);

        hospitalsArea = new JTextArea();
        hospitalsArea.setLineWrap(true);
        JScrollPane hospitalsScrollPane = new JScrollPane(hospitalsArea);
        hospitalsScrollPane.setBounds(120, 130, 200, 80);
        getContentPane().add(hospitalsScrollPane);

        JLabel lblSchedules = new JLabel("Schedules:");
        lblSchedules.setBounds(10, 220, 100, 20);
        getContentPane().add(lblSchedules);

        schedulesArea = new JTextArea();
        schedulesArea.setLineWrap(true);
        JScrollPane schedulesScrollPane = new JScrollPane(schedulesArea);
        schedulesScrollPane.setBounds(120, 220, 200, 80);
        getContentPane().add(schedulesScrollPane);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(120, 310, 80, 25);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });
        getContentPane().add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(220, 310, 100, 25);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new doctorHomePage(doctor);
                dispose();
            }
        });
        getContentPane().add(btnCancel);

        setVisible(true);
    }
    
    private void loadApprovedDoctors() {
        doctors = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("doctor_list.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            doctors = (List<Doctor>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveChanges() {
        doctor.setFirstName(firstNameField.getText());
        doctor.setLastName(lastNameField.getText());
        doctor.setEmail(emailField.getText());
        doctor.setLicenseNumber(licenseNumberField.getText());
        updateListFromTextArea(doctor.getHospitals(), hospitalsArea.getText());
        updateListFromTextArea(doctor.getSchedules(), schedulesArea.getText());

        // Write the updated Doctor object back to the file
        saveDoctorToFile("doctor_list.ser", doctor);

        JOptionPane.showMessageDialog(this, "Changes saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveDoctorToFile(String fileName, Doctor doctor) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        	loadApprovedDoctors();
        	
            out.writeObject(doctors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateListFromTextArea(List<String> list, String text) {
        list.clear();
        String[] lines = text.split("\n");
        for (String line : lines) {
            list.add(line.trim());
        }
    }

    public static void main(String[] args) {
        // Assuming you have a doctor object already
        Doctor doctor = new Doctor("John", "Doe", "john@example.com", "password", "123456");
        SwingUtilities.invokeLater(() -> new DoctorProfile(doctor));
    }
}
