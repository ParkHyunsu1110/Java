package java_2020_10_26_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainEventFrame2 extends JFrame {
	String i = "0";
	int j;
	JLabel lblNumber;
	public MainEventFrame2() {
		this.setSize(500, 500);
		JPanel panel = new JPanel();
		JButton btn = new JButton("버튼 클릭");
		
		ActionHandler action = new ActionHandler();
		lblNumber = new JLabel(i);
		JLabel lbl = new JLabel("번");
		btn.addActionListener(action);
		
		panel.add(btn);
		panel.add(lblNumber);
		panel.add(lbl);
		
		this.add(panel);
	}
	public void clickTimes() {
		j = Integer.parseInt(i);
		j++;
		i = String.valueOf(j);
		lblNumber.setText(i);
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			clickTimes();
		}	
	}
}
