package java_2020_11_02_3;

import java.awt.event.*;
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
		this.setSize(230, 250);
		
		panel_join = new JPanel();
		
		lblId = new JLabel("ID : ");
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
		this.panel_join.setLayout(new BoxLayout(this.panel_join, BoxLayout.Y_AXIS));
		this.add(panel_join);
	}
	public void joinUser() {
		Scanner sc  = new Scanner(System.in);
		String id = tfId.getText();
		String pw = pfPw.getText();
		String name = tfName.getText();
		String age = tfAge.getText();
		
		File file = new File("data/joinFile");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(id + " " + pw + " " + name + " " + age + "\n");
			fw.flush();
			
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�.\n���� �������� ���ư��ϴ�.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�.\n���� �������� ���ư��ϴ�.");
			
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
