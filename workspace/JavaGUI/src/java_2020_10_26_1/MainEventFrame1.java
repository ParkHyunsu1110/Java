package java_2020_10_26_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java_2020_10_26_1.MainFrame.ActionHandler;

public class MainEventFrame1 extends JFrame {
	JPanel panel;
	public MainEventFrame1() {
		setSize(500, 500);
		
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		
		ActionHandler action = new ActionHandler();
		JButton btnColor = new JButton("화면 전환");
		btnColor.addActionListener(action);
		panel.add(btnColor);
		
		this.add(panel);
	}
	public void changeColor() {
		panel.setBackground(Color.RED);
	}
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			changeColor();
		}
	}
}
