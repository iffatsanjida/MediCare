import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class patientHomePage extends JFrame {
private JFrame frame = new JFrame("Menu");
	
	public patientHomePage(Patient patient) {
		setTitle("Home Page");
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,200);
		setBounds(100, 100, 967, 585);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(75, 159, 166, 224);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton doctorListBtn = new JButton("See");
		doctorListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoctorList(patient.getEmail(), patient);
				dispose();
			}
		});
		doctorListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctorListBtn.setBounds(36, 187, 89, 23);
		panel.add(doctorListBtn);
		
		JLabel lblNewLabel = new JLabel("Doctor's List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 152, 146, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\to-do-list.png"));
		lblNewLabel_1.setBounds(20, 11, 146, 144);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(717, 159, 166, 224);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblHospitalAndAmbulance = new JLabel("Hospital and");
		lblHospitalAndAmbulance.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalAndAmbulance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHospitalAndAmbulance.setBounds(10, 135, 146, 34);
		panel_2_1.add(lblHospitalAndAmbulance);
		
		JButton seeHosAmbBtn = new JButton("See");
		seeHosAmbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seeHosAmbBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		seeHosAmbBtn.setBounds(36, 190, 89, 23);
		panel_2_1.add(seeHosAmbBtn);
		
		JLabel lblAmbulance = new JLabel("Ambulance");
		lblAmbulance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmbulance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmbulance.setBounds(10, 157, 146, 34);
		panel_2_1.add(lblAmbulance);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\ambulance.png"));
		lblNewLabel_4.setBounds(20, 11, 146, 128);
		panel_2_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(505, 159, 166, 224);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Blood Bank");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 155, 146, 34);
		panel_2.add(lblNewLabel_3);
		
		JButton doctorListBtn_2 = new JButton("See");
		doctorListBtn_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctorListBtn_2.setBounds(36, 190, 89, 23);
		panel_2.add(doctorListBtn_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\blood-type.png"));
		lblNewLabel_6.setBounds(20, 11, 146, 133);
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(289, 159, 166, 224);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Emergency");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 155, 146, 34);
		panel_1.add(lblNewLabel_2);
		
		JButton emergencyGoBtn = new JButton("Go");
		emergencyGoBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		emergencyGoBtn.setBounds(36, 190, 89, 23);
		panel_1.add(emergencyGoBtn);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\emergency-call.png"));
		lblNewLabel_5.setBounds(20, 11, 146, 133);
		panel_1.add(lblNewLabel_5);
		
		JButton profileBtn = new JButton(patient.getFirstName());
		profileBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		profileBtn.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\profile.png"));
		profileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileBtn.setBounds(579, 41, 178, 37);
		getContentPane().add(profileBtn);
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage();
				dispose();
			}
		});
		logOutBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		logOutBtn.setBounds(771, 41, 111, 37);
		getContentPane().add(logOutBtn);
		
		
		
		
		setVisible(true);
	}
}