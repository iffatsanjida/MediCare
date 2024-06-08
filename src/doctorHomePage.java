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

public class doctorHomePage extends JFrame{

	public doctorHomePage(Doctor doctor) {
		getContentPane().setBackground(new Color(125, 173, 196));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,200);
		setBounds(100, 100, 967, 585);
		getContentPane().setLayout(null);
		
		JButton profileBtn = new JButton(doctor.getFirstName());
		profileBtn.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\profile.png"));
		profileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoctorProfile(doctor);
				dispose();
			}
		});
		profileBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		profileBtn.setBounds(599, 37, 178, 37);
		getContentPane().add(profileBtn);
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage();
				dispose();
			}
		});
		logOutBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		logOutBtn.setBounds(791, 37, 111, 37);
		getContentPane().add(logOutBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(181, 179, 166, 224);
		getContentPane().add(panel);
		
		JButton pendingDoctorListBtn = new JButton("See");
		pendingDoctorListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		pendingDoctorListBtn.setBounds(36, 187, 89, 23);
		panel.add(pendingDoctorListBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\comments.png"));
		lblNewLabel.setBounds(20, 11, 146, 135);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Messages");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 152, 146, 34);
		panel.add(lblNewLabel_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(395, 179, 166, 224);
		getContentPane().add(panel_1);
		
		JButton doctorListBtn = new JButton("See");
		doctorListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctorListBtn.setBounds(36, 190, 89, 23);
		panel_1.add(doctorListBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Schedule");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 156, 146, 34);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\schedule.png"));
		lblNewLabel_1_1.setBounds(20, 11, 146, 144);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(611, 179, 166, 224);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Appointments");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 155, 146, 34);
		panel_2.add(lblNewLabel_3);
		
		JButton patientListBtn = new JButton("See");
		patientListBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		patientListBtn.setBounds(36, 190, 89, 23);
		panel_2.add(patientListBtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\MediCare\\src\\components\\medical-appointment.png"));
		lblNewLabel_2.setBounds(20, 11, 146, 133);
		panel_2.add(lblNewLabel_2);
		
		
		setVisible(true);
	}

}
