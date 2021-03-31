package java_2020_11_02_2;

import javax.swing.*;

public class NullFrame extends JFrame {
	JPanel panel;
	JButton btn1, btn2, btn3, btn4, btn5;
	public NullFrame() {
		this.setSize(500, 500);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		btn1 = new JButton("Btn 1");
		panel.add(btn1);
		btn1.setBounds(10, 10, 50, 50);
		
		btn2 = new JButton("Btn 2");
		panel.add(btn2);
		btn2.setBounds(80, 10, 300, 80);
		btn3 = new JButton("Btn 3");
		panel.add(btn3);
		btn3.setBounds(10, 80, 30, 200);
		
		btn4 = new JButton("Btn 4");
		panel.add(btn4);
		btn4.setBounds(200, 200, 100, 40);
		
		btn5 = new JButton("Btn 5");
		panel.add(btn5);
		btn5.setBounds(250, 250, 200, 20);
		this.add(panel);
		
	}
}
