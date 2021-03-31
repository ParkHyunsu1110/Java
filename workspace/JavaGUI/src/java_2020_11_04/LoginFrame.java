package java_2020_11_04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class LoginFrame extends JFrame {

	JPanel panel_login;
	JLabel lblId, lblPw;
	JTextField tfId, tfName, tfAge;
	JPasswordField pfPw;
	JButton btnLogin;
	
	ActionHandler actionHandler = new ActionHandler();
	public LoginFrame() {
		this.setSize(200, 250);
		
		panel_login = new JPanel();
		
		lblId = new JLabel("ID : ");
		panel_login.add(lblId);
		tfId = new JTextField(12);
		panel_login.add(tfId);
		
		lblPw = new JLabel("PW : ");
		panel_login.add(lblPw);
		pfPw = new JPasswordField(12);
		panel_login.add(pfPw);
		
		btnLogin = new JButton("로그인");
		btnLogin.setSize(100, 20);
		btnLogin.addActionListener(actionHandler);
		panel_login.add(btnLogin);
		
		this.add(panel_login);
	}
	public void loginUser() {
		Scanner sc;
		try {
			sc = new Scanner(new FileInputStream("data/info"));
			String id = tfId.getText();
			String pw = pfPw.getText();
			File file = new File("data/info");
			while(sc.hasNext()) {
				String id_infor = sc.next();
				String pw_infor = sc.next();
				String name_infor = sc.next();
				String age_infor = sc.next();
				
				if(id.equals(id_infor) && pw.equals(pw_infor)) {
					JOptionPane.showMessageDialog(null, name_infor + "님 환영합니다.");
					this.setVisible(false);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
			e.printStackTrace();
		}
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			loginUser();
		}	
	}
}
