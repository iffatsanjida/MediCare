import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class selectUsertype extends JFrame{
	public selectUsertype() {
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 668);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select User Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(96, 106, 348, 47);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoctorSignupPage();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(188, 210, 135, 37);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientSignUpPage();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(188, 273, 135, 37);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(96, 381, 219, 13);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Log in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(313, 379, 85, 21);
		getContentPane().add(btnNewButton_2);
		
		
		setVisible(true);
	}
}
