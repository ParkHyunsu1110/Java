package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import global.Buttons;
import global.MemberCheck;
import global.Constants.EButton;

public class FindFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tab_Id, tab_Pw;
	private JPanel panel_ID, panel_PW;
	private JTextField textField_Id, textField_Name, textField_Name_id, textField_Depart, textField_Depart_id, textField_Num, textField_Num_id, textField_Phone;
	private JLabel label_Id, label_name, label_depart, label_num, label_phone;
	Buttons btn_id, btn_pw;
	idActionHandler idAction;
	MemberCheck membercheck;
	pwActionHandler pwAction;
	private Session session;
	
	public FindFrame(Session session) {
		super("ID/PW 찾기");
		this.session = session;
		this.membercheck = new MemberCheck(session);
		this.idAction = new idActionHandler();
		this.pwAction = new pwActionHandler();
        
        this.tab_Id = new JTabbedPane(JTabbedPane.TOP);
        this.tab_Id.setPreferredSize(new Dimension(230,350));
        this.panel_ID = new JPanel();
        
        this.tab_Pw = new JTabbedPane(JTabbedPane.TOP);
        this.tab_Pw.setPreferredSize(new Dimension(250,350));
        this.panel_PW = new JPanel();
        
        this.tab_Id.addTab("ID 찾기", this.panel_ID);
        this.tab_Pw.addTab("PW 찾기", this.panel_PW);
        
        this.getContentPane().add(tab_Id, BorderLayout.CENTER);
        this.getContentPane().add(tab_Pw, BorderLayout.CENTER);
        this.setSize(560, 400);
        this.setLayout(new FlowLayout());
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
        
        find_Id(panel_ID);
        find_Pw(panel_PW);
	}

	private void find_Id(JPanel panel_ID) {
		JLabel label_01 = new JLabel();
		label_01.setPreferredSize(new Dimension(250,60));
		panel_ID.add(label_01);
		
		this.label_name = new JLabel("이름");
		this.label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_name.setPreferredSize(new Dimension(50,35));
		this.label_name.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_ID.add(this.label_name);
		
		this.textField_Name_id = new JTextField();
		this.textField_Name_id.setColumns(12);
		this.textField_Name_id.setPreferredSize(new Dimension(200,24));
		panel_ID.add(this.textField_Name_id);
		
		this.label_depart = new JLabel("학과");
		this.label_depart.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_depart.setPreferredSize(new Dimension(50,35));
		this.label_depart.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_ID.add(this.label_depart);
		
		this.textField_Depart_id = new JTextField();
		this.textField_Depart_id.setColumns(12);
		this.textField_Depart_id.setPreferredSize(new Dimension(200,24));
		panel_ID.add(this.textField_Depart_id);
		
		this.label_num = new JLabel("학번");
		this.label_num.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_num.setPreferredSize(new Dimension(50,35));
		this.label_num.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_ID.add(this.label_num);
		
		this.textField_Num_id = new JTextField();
		this.textField_Num_id.setColumns(12);
		this.textField_Num_id.setPreferredSize(new Dimension(200,24));
		panel_ID.add(this.textField_Num_id);
		
		this.btn_id = new Buttons(this.idAction, EButton.ID.getString());
		panel_ID.add(btn_id);
	}
	
	private void find_Pw(JPanel panel_PW) {
		JLabel label_01 = new JLabel();
		label_01.setPreferredSize(new Dimension(250,30));
		panel_PW.add(label_01);
		
		this.label_Id = new JLabel("아이디");
		this.label_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_Id.setPreferredSize(new Dimension(60,35));
		this.label_Id.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_PW.add(this.label_Id);
		
		this.textField_Id = new JTextField();
		this.textField_Id.setColumns(12);
		this.textField_Id.setPreferredSize(new Dimension(200,24));
		panel_PW.add(this.textField_Id);
		
		this.label_name = new JLabel("이름");
		this.label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_name.setPreferredSize(new Dimension(60,35));
		this.label_name.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_PW.add(this.label_name);
		
		this.textField_Name = new JTextField();
		this.textField_Name.setColumns(12);
		this.textField_Name.setPreferredSize(new Dimension(200,24));
		panel_PW.add(this.textField_Name);
		
		this.label_depart = new JLabel("학과");
		this.label_depart.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_depart.setPreferredSize(new Dimension(60,35));
		this.label_depart.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_PW.add(this.label_depart);
		
		this.textField_Depart = new JTextField();
		this.textField_Depart.setColumns(12);
		this.textField_Depart.setPreferredSize(new Dimension(200,24));
		panel_PW.add(this.textField_Depart);
		
		this.label_num = new JLabel("학번");
		this.label_num.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_num.setPreferredSize(new Dimension(60,35));
		this.label_num.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_PW.add(this.label_num);
		
		this.textField_Num = new JTextField();
		this.textField_Num.setColumns(12);
		this.textField_Num.setPreferredSize(new Dimension(200,24));
		panel_PW.add(this.textField_Num);
		
		this.label_phone = new JLabel("전화번호");
		this.label_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		this.label_phone.setPreferredSize(new Dimension(60,35));
		this.label_phone.setFont(new Font("DX피오피", Font.PLAIN, 15));
		panel_PW.add(this.label_phone);
		
		this.textField_Phone = new JTextField();
		this.textField_Phone.setColumns(12);
		this.textField_Phone.setPreferredSize(new Dimension(200,24));
		panel_PW.add(this.textField_Phone);
		
		this.btn_pw = new Buttons(this.pwAction, EButton.PW.getString());
		panel_PW.add(btn_pw);
	}
	private void complete() {
		this.dispose();
		this.textField_Id.setText(null);
		this.textField_Name_id.setText(null);
		this.textField_Depart_id.setText(null);
		this.textField_Num_id.setText(null);
		this.textField_Name.setText(null);
		this.textField_Depart.setText(null);
		this.textField_Num.setText(null);
		this.textField_Phone.setText(null);
	}
	
	private class idActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id_complete;
			id_complete = membercheck.find_id(textField_Name_id.getText(), textField_Depart_id.getText(), textField_Num_id.getText() );
			if (textField_Name_id.getText().equals("") || textField_Depart_id.getText().equals("")
					|| textField_Num_id.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "빈값 없이 모두 입력해주세요.");
				return;
			}
			if (id_complete == null) {
				JOptionPane.showMessageDialog(null, "일차하는 정보가 없습니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, textField_Name_id.getText() + "님의 아이디는  " + id_complete + " 입니다. \n 로그인 페이지로 이동합니다." );
			complete();
		}
	}
	
	private class pwActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String bt_pw = e.getActionCommand();
			String pw_complete;
			pw_complete = membercheck.find_pw(textField_Id.getText(), textField_Name.getText(), textField_Depart.getText(), textField_Num.getText(), textField_Phone.getText() );
			
			if (textField_Name.getText().equals("") || textField_Depart.getText().equals("")
					|| textField_Num.getText().equals("") || textField_Phone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "빈값 없이 모두 입력해주세요.");
				return;
			}
			if (pw_complete == null) {
				JOptionPane.showMessageDialog(null, "일차하는 정보가 없습니다.");
				return;
			}
			JOptionPane.showMessageDialog(null, textField_Name.getText() + "님의  비밀번호는  " + pw_complete + " 입니다. \n 로그인 페이지로 이동합니다." );
			complete();
		}
	}
}