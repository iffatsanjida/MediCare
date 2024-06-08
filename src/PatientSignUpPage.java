import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatientSignUpPage extends JFrame {
    private JPanel panel;
    private JPasswordField passwordField;
    private JTextPane firstName;
    private JTextPane lastName;
    private JTextPane email;

    public PatientSignUpPage() {
        getContentPane().setBackground(new Color(125, 173, 196));
        // Create the frame
        setTitle("Signup Page");
        setSize(500, 700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("SignUp for Patient");
        lblNewLabel.setBackground(new Color(101, 199, 248));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel.setBounds(136, 73, 268, 44);
        getContentPane().add(lblNewLabel);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblFirstName.setBackground(new Color(101, 199, 248));
        lblFirstName.setBounds(45, 178, 116, 44);
        getContentPane().add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblLastName.setBackground(new Color(101, 199, 248));
        lblLastName.setBounds(45, 248, 116, 44);
        getContentPane().add(lblLastName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblEmail.setBackground(new Color(101, 199, 248));
        lblEmail.setBounds(45, 324, 85, 44);
        getContentPane().add(lblEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPassword.setBackground(new Color(101, 199, 248));
        lblPassword.setBounds(45, 402, 102, 44);
        getContentPane().add(lblPassword);

        firstName = new JTextPane();
        firstName.setBounds(173, 188, 268, 23);
        getContentPane().add(firstName);

        lastName = new JTextPane();
        lastName.setBounds(173, 259, 268, 23);
        getContentPane().add(lastName);

        email = new JTextPane();
        email.setBounds(173, 332, 268, 23);
        getContentPane().add(email);

        passwordField = new JPasswordField();
        passwordField.setBounds(173, 411, 268, 32);
        getContentPane().add(passwordField);

        JButton joinBtn = new JButton("Join Now");
        joinBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input
                String fName = firstName.getText();
                String lName = lastName.getText();
                String emailText = email.getText();
                String password = new String(passwordField.getPassword());

                // Create a Patient object
                Patient patient = new Patient(fName, lName, emailText, password);

                // Read existing patients from file
                List<Patient> patients = new ArrayList<>();
                try (FileInputStream fileIn = new FileInputStream("patient_data.ser");
                     ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    patients = (List<Patient>) in.readObject();
                } catch (IOException | ClassNotFoundException ex) {
                    // If the file does not exist or is empty, initialize a new list
                    patients = new ArrayList<>();
                }

                // Add the new patient to the list
                patients.add(patient);

                // Serialize the updated list of patients to the file
                try (FileOutputStream fileOut = new FileOutputStream("patient_data.ser");
                     ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(patients);
                    JOptionPane.showMessageDialog(null, "Patient information saved successfully!");

                    // Redirect to login page
                    new Login();
                    dispose();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
        joinBtn.setBounds(315, 514, 130, 44);
        getContentPane().add(joinBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new selectUsertype();
                dispose();
            }
        });
        backBtn.setBackground(new Color(255, 255, 255));
        backBtn.setBounds(173, 514, 130, 44);
        getContentPane().add(backBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatientSignUpPage());
    }
}
