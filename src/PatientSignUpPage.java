import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PatientSignUpPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JPasswordField passwordField;

    public PatientSignUpPage() {
    	getContentPane().setBackground(new Color(143, 189, 246));
        // Create the frame
        setTitle("Signup Page");
        setSize(500,700);
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
        
        JTextPane firstName = new JTextPane();
        firstName.setBounds(173, 188, 268, 23);
        getContentPane().add(firstName);
        
        JTextPane lastName = new JTextPane();
        lastName.setBounds(173, 259, 268, 23);
        getContentPane().add(lastName);
        
        JTextPane email = new JTextPane();
        email.setBounds(173, 332, 268, 23);
        getContentPane().add(email);
        
        JButton joinBtn = new JButton("Join Now");
        joinBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        
        passwordField = new JPasswordField();
        passwordField.setBounds(173, 411, 268, 32);
        getContentPane().add(passwordField);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
