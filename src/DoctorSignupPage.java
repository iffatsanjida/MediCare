import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DoctorSignupPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JPasswordField passwordField;

    public DoctorSignupPage() {
    	getContentPane().setBackground(new Color(143, 189, 246));
        // Create the frame
        setTitle("Signup Page");
        setSize(500,700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        
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
        
        JTextPane firstName = new JTextPane();
        firstName.setBounds(45, 168, 396, 23);
        getContentPane().add(firstName);
        
        JTextPane lastName = new JTextPane();
        lastName.setBounds(45, 254, 396, 23);
        getContentPane().add(lastName);
        
        JTextPane email = new JTextPane();
        email.setBounds(45, 430, 396, 23);
        getContentPane().add(email);
        
        JButton joinBtn = new JButton("Join Now");
        joinBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        
        passwordField = new JPasswordField();
        passwordField.setBounds(45, 512, 396, 23);
        getContentPane().add(passwordField);
        
        JLabel lblNewLabel_1 = new JLabel("Doctor's License");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_1.setBackground(new Color(101, 199, 248));
        lblNewLabel_1.setBounds(45, 312, 150, 23);
        getContentPane().add(lblNewLabel_1);
        
        JTextPane lastName_1 = new JTextPane();
        lastName_1.setBounds(45, 345, 396, 23);
        getContentPane().add(lastName_1);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
