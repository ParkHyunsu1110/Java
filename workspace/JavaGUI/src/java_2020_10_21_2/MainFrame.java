package java_2020_10_21_2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setSize(200, 150);
		
		JPanel panel1 = new JPanel();
		panel1.setSize(100, 150);
		panel1.setBackground(Color.red);
		add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(100, 150);
		panel2.setBackground(Color.yellow);
		add(panel2);
	}
}
