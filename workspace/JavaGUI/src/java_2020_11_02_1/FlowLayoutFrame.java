package java_2020_11_02_1;

import java.awt.FlowLayout;
import javax.swing.*;

public class FlowLayoutFrame extends JFrame {
	JButton btn1, btn2, btn3, btn4, btn5;
	JPanel panel;
	public FlowLayoutFrame() {
		this.setSize(230, 150);
		panel = new JPanel();
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 50, 50);
		
		btn1 = new JButton("Btn 1");
		panel.add(btn1);
		
		btn2 = new JButton("Btn 2");
		panel.add(btn2);
		
		btn3 = new JButton("Btn 3");
		panel.add(btn3);
		
		btn4 = new JButton("Btn 4");
		panel.add(btn4);
		
		btn5 = new JButton("Btn 5");
		panel.add(btn5);
		
		this.add(panel);
		this.panel.setLayout(flow);
	}
}
