package java_2020_10_26_1;

import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	JLabel lbl;
	public MainFrame() {
		setSize(500, 500);
		JPanel panel = new JPanel();
		
		ActionHandler action = new ActionHandler();
		JButton btn = new JButton("버튼");
		btn.addActionListener(action);
		panel.add(btn);
		
		lbl = new JLabel("이곳에 글자가 들어옵니다.");		
		panel.add(lbl);
		
		this.add(panel);
	}
	public void changeText() {
		lbl.setText("할룽");
	}
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			changeText();
		}		
	}	
}
