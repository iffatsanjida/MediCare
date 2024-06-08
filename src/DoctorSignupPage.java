import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorSignupPage extends JFrame {
    private JTextPane firstName;
    private JTextPane lastName;
    private JTextPane email;
    private JPasswordField passwordField;
    private JTextPane licenseNumber;

    public DoctorSignupPage() {
        getContentPane().setBackground(new Color(125, 173, 196));
        setTitle("Signup Page");
        setSize(500, 700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("SignUp for Doctor");
        lblNewLabel.setBackground(new Color(101, 199, 248));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel.setBounds(136, 73, 268, 44);
        getContentPane().add(lblNewLabel);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblFirstName.setBackground(new Color(101, 199, 248));
        lblFirstName.setBounds(45, 127, 116, 44);
        getContentPane().add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblLastName.setBackground(new Color(101, 199, 248));
        lblLastName.setBounds(45, 214, 116, 44);
        getContentPane().add(lblLastName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblEmail.setBackground(new Color(101, 199, 248));
        lblEmail.setBounds(45, 391, 85, 44);
        getContentPane().add(lblEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPassword.setBackground(new Color(101, 199, 248));
        lblPassword.setBounds(45, 473, 102, 44);
        getContentPane().add(lblPassword);

        firstName = new JTextPane();
        firstName.setBounds(45, 168, 396, 23);
        getContentPane().add(firstName);

        lastName = new JTextPane();
        lastName.setBounds(45, 254, 396, 23);
        getContentPane().add(lastName);

        licenseNumber = new JTextPane();
        licenseNumber.setBounds(45, 345, 396, 23);
        getContentPane().add(licenseNumber);

        JLabel lblLicenseNumber = new JLabel("License Number:");
        lblLicenseNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblLicenseNumber.setBackground(new Color(101, 199, 248));
        lblLicenseNumber.setBounds(45, 312, 150, 23);
        getContentPane().add(lblLicenseNumber);

        email = new JTextPane();
        email.setBounds(45, 430, 396, 23);
        getContentPane().add(email);

        passwordField = new JPasswordField();
        passwordField.setBounds(45, 512, 396, 23);
        getContentPane().add(passwordField);

        JButton joinBtn = new JButton("Join Now");
        joinBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input
                String fName = firstName.getText();
                String lName = lastName.getText();
                String emailText = email.getText();
                String password = new String(passwordField.getPassword());
                String license = licenseNumber.getText();

                // Create a Doctor object
                Doctor doctor = new Doctor(fName, lName, emailText, password, license);

                // Load existing pending doctor list
                List<Doctor> pendingDoctors = loadPendingDoctors();

                // Add the new doctor to the pending list
                pendingDoctors.add(doctor);

                // Serialize the updated pending doctor list to the file
                savePendingDoctors(pendingDoctors);

                JOptionPane.showMessageDialog(null, "Doctor information saved and pending for approval!");

                // Redirect to login page or another appropriate page
                new Login();
                dispose();
            }
        });
        
        joinBtn.setBounds(325, 577, 130, 44);
        getContentPane().add(joinBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new selectUsertype();
                dispose();
            }
        });
        backBtn.setBackground(new Color(255, 255, 255));
        backBtn.setBounds(173, 577, 130, 44);
        getContentPane().add(backBtn);

        setVisible(true);
    }
    
    private List<Doctor> loadPendingDoctors() {
        List<Doctor> pendingDoctors = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("pending_doctor_list.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pendingDoctors = (List<Doctor>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pendingDoctors;
    }

    private void savePendingDoctors(List<Doctor> pendingDoctors) {
        try (FileOutputStream fileOut = new FileOutputStream("pending_doctor_list.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pendingDoctors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
