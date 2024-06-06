import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Main{
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Medi Care");
		frame.setSize(1320,720);
		frame.setVisible(true);
		ImageIcon image = new ImageIcon("logo.png");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(Color.black);
		
	

		

		
	}
}


