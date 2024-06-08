import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AdminDashboard extends JFrame {
private JFrame frame = new JFrame("Menu");
	
	public AdminDashboard() {
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,200);
		setBounds(100, 100, 967, 585);
		getContentPane().setLayout(null);
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage();
				dispose();
			}
		});
		logOutBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		logOutBtn.setBounds(760, 43, 111, 37);
		getContentPane().add(logOutBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(65, 170, 166, 224);
		getContentPane().add(panel);
		
		JButton pendingDoctorListBtn = new JButton("See");
		pendingDoctorListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new pendingDocList();
				dispose();
			}
		});
		pendingDoctorListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		pendingDoctorListBtn.setBounds(36, 187, 89, 23);
		panel.add(pendingDoctorListBtn);
		
		JLabel lblList = new JLabel("List");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblList.setBounds(10, 157, 146, 34);
		panel.add(lblList);
		
		JLabel lblPendingDoctors = new JLabel("Pending Doctor's");
		lblPendingDoctors.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendingDoctors.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPendingDoctors.setBounds(10, 135, 146, 34);
		panel.add(lblPendingDoctors);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\test.png"));
		lblNewLabel.setBounds(20, 11, 146, 135);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(279, 170, 166, 224);
		getContentPane().add(panel_1);
		
		JButton doctorListBtn = new JButton("See");
		doctorListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoctorList("admin@admin.com", null);
				dispose();
			}
		});
		doctorListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctorListBtn.setBounds(36, 190, 89, 23);
		panel_1.add(doctorListBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor's List");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 156, 146, 34);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\to-do-list.png"));
		lblNewLabel_1_1.setBounds(20, 11, 146, 144);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(495, 170, 166, 224);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patient's List");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 155, 146, 34);
		panel_2.add(lblNewLabel_3);
		
		JButton patientListBtn = new JButton("See");
		patientListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		patientListBtn.setBounds(36, 190, 89, 23);
		panel_2.add(patientListBtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\list.png"));
		lblNewLabel_2.setBounds(20, 11, 146, 133);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(707, 170, 166, 224);
		getContentPane().add(panel_2_1);
		
		JLabel lblHospitalAndAmbulance = new JLabel("Hospital and");
		lblHospitalAndAmbulance.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalAndAmbulance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHospitalAndAmbulance.setBounds(10, 135, 146, 34);
		panel_2_1.add(lblHospitalAndAmbulance);
		
		JButton seeHosAmbBtn = new JButton("See");
		seeHosAmbBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		seeHosAmbBtn.setBounds(36, 190, 89, 23);
		panel_2_1.add(seeHosAmbBtn);
		
		JLabel lblAmbulanceInfo = new JLabel("Ambulance Info");
		lblAmbulanceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmbulanceInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmbulanceInfo.setBounds(10, 157, 146, 34);
		panel_2_1.add(lblAmbulanceInfo);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\ambulance.png"));
		lblNewLabel_4.setBounds(20, 11, 146, 128);
		panel_2_1.add(lblNewLabel_4);
		
		
		
		
		setVisible(true);
	}
}