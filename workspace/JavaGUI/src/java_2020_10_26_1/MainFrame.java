package java_2020_10_26_1;

import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	JLabel lbl;
	public MainFrame() {
		setSize(500, 500);
		JPanel panel = new JPanel();
		
		ActionHandler action = new ActionHandler();
		JButton btn = new JButton("��ư");
		btn.addActionListener(action);
		panel.add(btn);
		
		lbl = new JLabel("�̰��� ���ڰ� ���ɴϴ�.");		
		panel.add(lbl);
		
		this.add(panel);
	}
	public void changeText() {
		lbl.setText("�ҷ�");
	}
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			changeText();
		}		
	}	
}
