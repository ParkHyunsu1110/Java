package java_2020_10_21_Practice;
import javax.swing.*;
public class MainFrameA extends JFrame {
	public MainFrameA() {
		setSize(200, 80);
		JPanel panel = new JPanel();
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("������");
		
		JButton checkBtn = new JButton("Ȯ��");
		
		panel.add(nameLabel);
		panel.add(checkBtn);
		add(panel);
	}
}
