package java_2020_11_02_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	JoinFrame joinFrame;
	
	JPanel panel_main;
	JButton btnLogin, btnJoin;
	
	ActionHandler actionHandler = new ActionHandler();
	public MainFrame() {
		this.setSize(500, 500);
		
		panel_main = new JPanel();
		
		btnLogin = new JButton("로그인");
		panel_main.add(btnLogin);
		btnLogin.addActionListener(actionHandler);
		
		btnJoin = new JButton("회원가입");
		panel_main.add(btnJoin);
		btnJoin.addActionListener(actionHandler);
		
		this.add(panel_main);
	}
	public void join() {
		joinFrame = new JoinFrame();
		joinFrame.setVisible(true);
		joinFrame.setLocationRelativeTo(null);
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String sign = e.getActionCommand();
			if(sign.equals("회원가입")) join();
		}		
	}
}
