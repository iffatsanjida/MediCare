import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelcomePage extends JFrame {
private JFrame frame = new JFrame("Menu");
	
	public WelcomePage() {
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,200);
		setBounds(100, 100, 967, 585);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("About");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(36, 54, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Contact");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(150, 54, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Help");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(266, 54, 85, 21);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Welcome to");
		lblNewLabel.setForeground(new Color(60, 74, 87));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 45));
		lblNewLabel.setBounds(607, 95, 334, 61);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Join us in creating a healthier, more connected world");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(369, 245, 589, 26);
		getContentPane().add(lblNewLabel_1);
		
		JButton startJourney = new JButton("Start your journey with us >");
		startJourney.setForeground(Color.BLACK);
		
		startJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selectUsertype();
				dispose();
			}
		});
		startJourney.setBackground(Color.WHITE);
		startJourney.setFont(new Font("Tahoma", Font.BOLD, 16));
		startJourney.setBounds(630, 361, 278, 26);
		getContentPane().add(startJourney);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon originalIcon = new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\bg.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(512,512, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblNewLabel_2.setIcon(resizedIcon);
		lblNewLabel_2.setBounds(-64, 127, 415, 485);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblMedicare = new JLabel("MediCare");
		lblMedicare.setForeground(new Color(255, 0, 0));
		lblMedicare.setFont(new Font("Verdana", Font.BOLD, 65));
		lblMedicare.setBounds(569, 158, 382, 61);
		getContentPane().add(lblMedicare);
		
		JLabel lblNewLabel_1_1 = new JLabel("where patients and doctors collaborate seamlessly for ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(361, 269, 589, 26);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("better health outcomes.");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(666, 293, 589, 26);
		getContentPane().add(lblNewLabel_1_1_1);
		
		
		
		
		setVisible(true);
	}
}