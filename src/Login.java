import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Login extends JFrame {
    private JTextField textField_1;
    private JPasswordField passwordField;

    public Login() {
        getContentPane().setBackground(new Color(125, 173, 196));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 544, 668);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(63, 231, 104, 24);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Log in");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(206, 103, 194, 35);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(63, 287, 104, 24);
        getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(177, 226, 255, 29);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(177, 287, 255, 29);
        getContentPane().add(passwordField);

        JButton loginBtn = new JButton("Log in");
        loginBtn.setForeground(new Color(0, 0, 0));
        loginBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        loginBtn.setBounds(334, 407, 98, 29);
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textField_1.getText();
                String password = new String(passwordField.getPassword());

                if (email.equals("admin@admin.com") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Admin login successful!");
                    // Redirect to admin dashboard
                    new AdminDashboard();
                    dispose();
                } else {
                    boolean loginSuccessful = false;

                    // Check if the user is a patient
                    try (FileInputStream fileIn = new FileInputStream("patient_data.ser");
                         ObjectInputStream in = new ObjectInputStream(fileIn)) {

                        List<Patient> patients = (List<Patient>) in.readObject();

                        for (Patient patient : patients) {
                            if (patient.getEmail().equals(email) && patient.getPassWord().equals(password)) {
                                JOptionPane.showMessageDialog(null, "Patient login successful!");
                                // Redirect to patient home page
                                new patientHomePage(patient);
                                loginSuccessful = true;
                                dispose();
                                break;
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                    	JOptionPane.showMessageDialog(null, "Invalid email or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Check if the user is a doctor
                    if (!loginSuccessful) {
                        try (FileInputStream fileIn = new FileInputStream("doctor_list.ser");
                             ObjectInputStream in = new ObjectInputStream(fileIn)) {

                            List<Doctor> doctors = (List<Doctor>) in.readObject();

                            for (Doctor doctor : doctors) {
                                if (doctor.getEmail().equals(email) && doctor.getPassword().equals(password)) {
                                    JOptionPane.showMessageDialog(null, "Doctor login successful!");
                                    // Redirect to doctor home page
                                    new doctorHomePage(doctor);
                                    loginSuccessful = true;
                                    dispose();
                                    break;
                                }
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (!loginSuccessful) {
                        JOptionPane.showMessageDialog(null, "Invalid email or password.");
                    }
                }
            }
        });
        getContentPane().add(loginBtn);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new WelcomePage();
        		dispose();
        	}
        });
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnBack.setBounds(220, 407, 98, 29);
        getContentPane().add(btnBack);

        setVisible(true);
    }

}
