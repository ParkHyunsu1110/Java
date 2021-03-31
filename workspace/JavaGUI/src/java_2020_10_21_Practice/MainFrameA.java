package java_2020_10_21_Practice;
import javax.swing.*;
public class MainFrameA extends JFrame {
	public MainFrameA() {
		setSize(200, 80);
		JPanel panel = new JPanel();
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("박현수");
		
		JButton checkBtn = new JButton("확인");
		
		panel.add(nameLabel);
		panel.add(checkBtn);
		add(panel);
	}
}
