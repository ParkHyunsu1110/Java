package java_2020_11_02_1;

import java.awt.BorderLayout;

import javax.swing.*;

public class BorderLayoutFrame extends JFrame {
	JPanel panel;
	JButton btn1, btn2, btn3, btn4, btn5;
	public BorderLayoutFrame() {
		
		BorderLayout border = new BorderLayout(50, 50);
		
		this.setSize(500, 500);
		panel = new JPanel();
		panel.setLayout(border);
		
		btn1 = new JButton("Btn 1");
		panel.add(btn1, border.NORTH);
		
		btn2 = new JButton("Btn 2");
		panel.add(btn2, border.WEST);
		
		btn3 = new JButton("Btn 3");
		panel.add(btn3, border.CENTER);
		
		btn4 = new JButton("Btn 4");
		panel.add(btn4, border.EAST);
		
		btn5 = new JButton("Btn 5");
		panel.add(btn5, border.SOUTH);
		
		this.add(panel);
		
	}
}
