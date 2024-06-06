import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {
private JFrame frame = new JFrame("Menu");
	
	public WelcomePage() {
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 585);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("About");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(36, 31, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Contact");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(152, 31, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Help");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(266, 31, 85, 21);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 60));
		lblNewLabel.setBounds(506, 190, 437, 61);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your problem,we solve");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(543, 250, 427, 26);
		getContentPane().add(lblNewLabel_1);
		
		JButton startJourney = new JButton("Start your journey with us >");
		startJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selectUsertype();
				dispose();
			}
		});
		startJourney.setBackground(new Color(192, 192, 192));
		startJourney.setFont(new Font("Tahoma", Font.BOLD, 16));
		startJourney.setBounds(558, 330, 263, 40);
		getContentPane().add(startJourney);
		
		
		
		
		setVisible(true);
	}
}