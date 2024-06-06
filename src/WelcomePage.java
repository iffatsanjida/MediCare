import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Welcome!");

	WelcomePage(String userID) {
		welcomeLabel.setBounds(112, 6, 200, 35);
		welcomeLabel.setText("Welcome, " + userID + "!");
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeLabel.setVerticalAlignment(JLabel.CENTER);

		frame.getContentPane().add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
}
