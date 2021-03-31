package java_2020_11_04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class JoinFrame extends JFrame {
	
	JPanel panel_join;
	JLabel lblId, lblPw, lblName, lblAge;
	JTextField tfId, tfName, tfAge;
	JPasswordField pfPw;
	JButton btnJoin;
	
	ActionHandler actionHandler = new ActionHandler();
	public JoinFrame() {
		this.setSize(200, 250);
		
		panel_join = new JPanel();

		lblId = new JLabel("ID :   ");
		panel_join.add(lblId);
		
		tfId = new JTextField(12);
		panel_join.add(tfId);
		
		lblPw = new JLabel("PW : ");
		panel_join.add(lblPw);
		
		pfPw = new JPasswordField(12);
		panel_join.add(pfPw);
		
		lblName = new JLabel("�̸� : ");
		panel_join.add(lblName);
		
		tfName = new JTextField(12);
		panel_join.add(tfName);
		
		lblAge = new JLabel("���� : ");
		panel_join.add(lblAge);
		
		tfAge = new JTextField(12);
		panel_join.add(tfAge);
		
		btnJoin = new JButton("�����ϱ�");
		btnJoin.setSize(100, 20);
		btnJoin.addActionListener(actionHandler);
		panel_join.add(btnJoin);
		
		this.add(panel_join);
	}
	public void joinUser() {
		Scanner sc  = new Scanner(System.in);
		String id = tfId.getText();
		String pw = pfPw.getText();
		String name = tfName.getText();
		String age = tfAge.getText();
		
		File file = new File("data/info");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(id + " " + pw + " " + name + " " + age + "\n");
			fw.flush();
			
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�.\n���� �������� ���ư��ϴ�.");
			this.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�.\n���� �������� ���ư��ϴ�.");
			this.setVisible(false);
			e.printStackTrace();
		}
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			joinUser();
		}		
	}
}
