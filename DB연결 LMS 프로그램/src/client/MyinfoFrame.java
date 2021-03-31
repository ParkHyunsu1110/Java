package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import global.Buttons;
import global.Constants.EButton;
import global.MemberCheck;
import valueobject.VOMember;

public class MyinfoFrame extends JFrame {
	private Session session;
	private JPanel panel_info;
	private JTextField textField_Id, textField_Name, textField_Campus, textField_College, textField_Depart, textField_Num, textField_Birth, textField_Phone;
	private JPasswordField textField_nowPW, textField_changePw, textField_changePwChk;
	private Buttons btn_change;
	private String userId;
	private String pw;
	Vector<VOMember> members;
	Vector<VOMember> members_infor;
	String member_re="";
	ActionHandler actionHandler;

	private void Reset(JTextField textField_Id, JTextField textField_nowPW, JTextField textField_changePw, JTextField textField_changePwChk,
			JTextField textField_Name, JTextField textField_Depart, JTextField textField_Num, JTextField textField_Birth, JTextField textField_Phone) {
		this.textField_Id.setText(null);
		this.textField_nowPW.setText(null);
		this.textField_changePw.setText(null);
		this.textField_changePwChk.setText(null);
		this.textField_Name.setText(null);
		this.textField_Campus.setText(null);
		this.textField_College.setText(null);
		this.textField_Depart.setText(null);
		this.textField_Num.setText(null);
		this.textField_Birth.setText(null);
		this.textField_Phone.setText(null);
	}

	public MyinfoFrame(Session session) {
		this.actionHandler = new ActionHandler();
		this.session = session;

		setForeground(Color.WHITE);
		setBackground(Color.PINK);
		setTitle("\uD68C\uC6D0 \uAC00\uC785");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
		this.setSize(330,600);
		this.setResizable(false);
		
		this.panel_info = new JPanel();
		this.panel_info.setBackground(Color.WHITE);
		this.panel_info.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel_info);
		this.panel_info.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel label_Id = new JLabel("아이디");
		label_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Id.setPreferredSize(new Dimension(150,35));
		label_Id.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_Id);

		this.textField_Id = new JTextField();
		this.textField_Id.setColumns(12);
		this.textField_Id.enable(false);;
		this.panel_info.add(this.textField_Id);
		
		JLabel label_pw = new JLabel("현재 비밀번호");
		label_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		label_pw.setPreferredSize(new Dimension(150,35));
		label_pw.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_pw);
		
		this.textField_nowPW = new JPasswordField();
		this.textField_nowPW.setColumns(12);
		this.panel_info.add(this.textField_nowPW);
		
		JLabel lable_changepw = new JLabel("변경 비밀번호");
		lable_changepw.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_changepw.setPreferredSize(new Dimension(150,35));
		lable_changepw.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(lable_changepw);
		
		this.textField_changePw = new JPasswordField();
		this.textField_changePw.setColumns(12);
		this.panel_info.add(this.textField_changePw);

		JLabel label_changepwok = new JLabel("변경 비밀번호 확인");
		label_changepwok.setHorizontalAlignment(SwingConstants.RIGHT);
		label_changepwok.setPreferredSize(new Dimension(150,35));
		label_changepwok.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_changepwok);
		
		this.textField_changePwChk = new JPasswordField();
		this.textField_changePwChk.setColumns(12);
		this.panel_info.add(this.textField_changePwChk);

		JLabel label_name = new JLabel("이름");
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setPreferredSize(new Dimension(150,35));
		label_name.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_name);

		this.textField_Name = new JTextField();
		this.textField_Name.setColumns(12);
		this.textField_Name.enable(false);
		this.panel_info.add(this.textField_Name);
		
		JLabel label_campus = new JLabel("캠퍼스");
		label_campus.setHorizontalAlignment(SwingConstants.RIGHT);
		label_campus.setPreferredSize(new Dimension(150,35));
		label_campus.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_campus);
		
		this.textField_Campus = new JTextField();
		this.textField_Campus.setColumns(12);
		this.textField_Campus.enable(false);
		this.panel_info.add(this.textField_Campus);
		
		JLabel label_college = new JLabel("대학");
		label_college.setHorizontalAlignment(SwingConstants.RIGHT);
		label_college.setPreferredSize(new Dimension(150,35));
		label_college.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_college);
		
		this.textField_College = new JTextField();
		this.textField_College.setColumns(12);
		this.textField_College.enable(false);
		this.panel_info.add(this.textField_College);
		
		JLabel label_depart = new JLabel("학과");
		label_depart.setHorizontalAlignment(SwingConstants.RIGHT);
		label_depart.setPreferredSize(new Dimension(150,35));
		label_depart.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_depart);
		
		this.textField_Depart = new JTextField();
		this.textField_Depart.setColumns(12);
		this.textField_Depart.enable(false);
		this.panel_info.add(this.textField_Depart);
		
		JLabel label_num = new JLabel("학번");
		label_num.setHorizontalAlignment(SwingConstants.RIGHT);
		label_num.setPreferredSize(new Dimension(150,35));
		label_num.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_num);
		
		this.textField_Num = new JTextField();
		this.textField_Num.setColumns(12);
		this.textField_Num.enable(false);;
		this.panel_info.add(this.textField_Num);

		JLabel label_birth = new JLabel("생일");
		label_birth.setHorizontalAlignment(SwingConstants.RIGHT);
		label_birth.setPreferredSize(new Dimension(150,35));
		label_birth.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_birth);

		this.textField_Birth = new JTextField();
		this.textField_Birth.setColumns(12);
		this.panel_info.add(this.textField_Birth);

		JLabel label_phone = new JLabel("핸드폰 번호");
		label_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		label_phone.setPreferredSize(new Dimension(150,35));
		label_phone.setFont(new Font("DX피오피", Font.PLAIN, 15));
		this.panel_info.add(label_phone);
		
		this.textField_Phone = new JTextField();
		this.textField_Phone.setColumns(12);
		this.panel_info.add(this.textField_Phone);
		
		JLabel label_01 = new JLabel();
		label_01.setPreferredSize(new Dimension(50,18));
		panel_info.add(label_01);
		
		this.btn_change = new Buttons(this.actionHandler, EButton.Rewirte.getString());
		this.btn_change.setPreferredSize(new Dimension(100,30));
		label_01.setPreferredSize(new Dimension(120,18));
		panel_info.add(label_01);
		this.panel_info.add(btn_change);
	}

	private void complete() {
		this.dispose();
		initialize(userId);
		textField_changePw.setText("");
		textField_changePwChk.setText("");
		textField_nowPW.setText("");
	}

	public void initialize(String userId) {
		this.userId = userId;
		
		this.session.sendProtocol("StudentManager/getMembers/member/all");
		this.members_infor = this.session.getMemberAll();
		
		this.session.sendProtocol("StudentManager/getInfor/member/" + userId);
		VOMember voMember = this.session.getMemberObject();
		
		this.textField_Id.setText(voMember.getUserId());
		this.textField_Name.setText(voMember.getName());
		this.textField_Campus.setText(voMember.getCampus());
		this.textField_College.setText(voMember.getCollege());
		this.textField_Depart.setText(voMember.getDepartment());
		this.textField_Birth.setText(voMember.getBirth());
		this.textField_Num.setText(voMember.getNumber());
		this.textField_Phone.setText(voMember.getPhone());
		this.pw = voMember.getPassword();
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			boolean bPasswordMatchChk = false; 
			MemberCheck joinchk = new MemberCheck(session);
			bPasswordMatchChk = joinchk.PasswordMatchChk(textField_changePw.getText(), textField_changePwChk.getText());
			if(textField_nowPW.getText().equals("")){
				JOptionPane.showMessageDialog(null, "현재 비밀번호를 입력해 주세요.");
				return;
			} else if(!(textField_nowPW.getText().equals(pw))) {
				JOptionPane.showMessageDialog(null, "현재 비밀번호가 다릅니다. 비밀번호를 다시 확인해 주세요!!");
				return;
			}
			if (textField_Name.getText().equals("") || textField_Birth.getText().equals("")
					|| textField_Phone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "빈값 없이 모두 입력해주세요.");
				return;
			}
			if (!bPasswordMatchChk) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 비밀번호를 다시 확인해주세요.");
				return;
			}
			member_re = textField_Id.getText() + "," + textField_changePw.getText() + "," + textField_Name.getText() + "," +
					textField_Campus.getText() + "," + textField_College.getText() + "," + textField_Depart.getText() + "," + textField_Num.getText() + "," 
					+ textField_Birth.getText() + "," + textField_Phone.getText();

			session.sendProtocol("StudentManager/writeMember/member/" + member_re);
			VOMember vo = session.getMemberObject();
			JOptionPane.showMessageDialog(null, "정보가 변경되었습니다.");
			member_re = "";
			complete();
		}
	}
}
