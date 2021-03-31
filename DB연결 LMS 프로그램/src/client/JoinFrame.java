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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import valueobject.VOLecture;
import valueobject.VOMember;
@SuppressWarnings("serial")
public class JoinFrame extends JFrame {
	private JPanel panel_new;
	private JTextField textField_Id, textField_Name, textField_Num, textField_Birth, textField_Phone;
	private JPasswordField textField_PW, textField_PwChk;
	private JButton button_idcheck, button_new;
	private JComboBox combo_campus, combo_college, combo_department;
	private int flag = 0;
	private boolean Idrepeat = false;
	private String selectCampus, selectCollege, selectDepartment = null;
	private Session session;
	private Vector<VOLecture> campus, college, department;
	private DefaultComboBoxModel model;
	Buttons btn_new, btn_idcheck;
	newAction newAction;
	checkAction checkAction;
	SelectAction selectAction;

	private void Reset() {
		this.textField_Id.setText(null);
		this.textField_PW.setText(null);
		this.textField_PwChk.setText(null);
		this.textField_Name.setText(null);
		this.textField_Num.setText(null);
		this.textField_Birth.setText(null);
		this.textField_Phone.setText(null);
		this.combo_college = new JComboBox();
		this.combo_college.repaint();
	}

	public JoinFrame(Session session, Vector<VOLecture> campus) {
		setForeground(Color.WHITE);
		setBackground(Color.PINK);
		setTitle("\uD68C\uC6D0 \uAC00\uC785");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		this.setSize(360,500);
		this.setResizable(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
		this.session = session;
		this.newAction = new newAction();
		this.checkAction = new checkAction();
		this.selectAction = new SelectAction();
		this.campus = campus;

		this.panel_new = new JPanel();
		this.panel_new.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel_new.setLayout(new FlowLayout(FlowLayout.LEADING));
		setContentPane(panel_new);

		JLabel label_Id = new JLabel("���̵�");
		label_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Id.setPreferredSize(new Dimension(100,35));
		label_Id.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_Id);

		this.textField_Id = new JTextField();
		this.textField_Id.setColumns(12);
		this.panel_new.add(this.textField_Id);

		this.btn_idcheck = new Buttons(this.checkAction, "�ߺ�Ȯ��  ");
		this.panel_new.add(btn_idcheck);

		JLabel label_pw = new JLabel("��й�ȣ");
		label_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		label_pw.setPreferredSize(new Dimension(100,35));
		label_pw.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_pw);

		this.textField_PW = new JPasswordField();
		this.textField_PW.setColumns(12);
		this.panel_new.add(this.textField_PW);

		JLabel label_pwok = new JLabel("��й�ȣ Ȯ��");
		label_pwok.setBackground(Color.GRAY);
		label_pwok.setHorizontalAlignment(SwingConstants.RIGHT);
		label_pwok.setPreferredSize(new Dimension(100,35));
		label_pwok.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_pwok);

		this.textField_PwChk = new JPasswordField();
		this.textField_PwChk.setColumns(12);
		this.panel_new.add(this.textField_PwChk);

		JLabel label_name = new JLabel("�̸�");
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setPreferredSize(new Dimension(100,35));
		label_name.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_name);

		this.textField_Name = new JTextField();
		this.textField_Name.setColumns(12);
		this.panel_new.add(this.textField_Name);

		//ķ�۽�
		JLabel lable_campus = new JLabel("ķ�۽�");
		lable_campus.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_campus.setPreferredSize(new Dimension(100,35));
		lable_campus.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(lable_campus);

		Vector<String> campus_name = new Vector<String>(); 
		for(int i=0; i<this.campus.size();i++) {
			campus_name.add(this.campus.get(i).getName());
		}
		this.model = new DefaultComboBoxModel(campus_name);

		this.combo_campus = new JComboBox(this.model);
		this.combo_campus.setActionCommand("ķ�۽�");
		this.combo_campus.setPreferredSize(new Dimension(150,30));
		this.combo_campus.addActionListener(selectAction);
		this.panel_new.add(this.combo_campus);

		JLabel lable_college = new JLabel("�ܰ�����");
		lable_college.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_college.setPreferredSize(new Dimension(100,35));
		lable_college.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(lable_college);

		this.combo_college = new JComboBox();
		this.combo_college.setActionCommand("�ܰ�����");
		this.combo_college.setPreferredSize(new Dimension(150,30));
		this.combo_college.addActionListener(selectAction);
		this.panel_new.add(this.combo_college);

		JLabel lable_department = new JLabel("�а�");
		lable_department.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_department.setPreferredSize(new Dimension(100,35));
		lable_department.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(lable_department);

		this.combo_department = new JComboBox();
		this.combo_department.setActionCommand("�а�");
		this.combo_department.setPreferredSize(new Dimension(150,30));
		this.combo_department.addActionListener(selectAction);
		this.panel_new.add(this.combo_department);
		//�ܴ�
		//�а�

		JLabel label_num = new JLabel("�й�");
		label_num.setHorizontalAlignment(SwingConstants.RIGHT);
		label_num.setPreferredSize(new Dimension(100,35));
		label_num.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_num);

		this.textField_Num = new JTextField();
		this.textField_Num.setColumns(12);
		this.panel_new.add(this.textField_Num);

		JLabel label_birth = new JLabel("����");
		label_birth.setHorizontalAlignment(SwingConstants.RIGHT);
		label_birth.setPreferredSize(new Dimension(100,35));
		label_birth.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_birth);

		this.textField_Birth = new JTextField();
		this.textField_Birth.setColumns(12);
		this.panel_new.add(this.textField_Birth);

		JLabel label_phone = new JLabel("�ڵ��� ��ȣ");
		label_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		label_phone.setPreferredSize(new Dimension(100,35));
		label_phone.setFont(new Font("DX�ǿ���", Font.PLAIN, 15));
		this.panel_new.add(label_phone);

		this.textField_Phone = new JTextField();
		this.textField_Phone.setColumns(12);
		this.panel_new.add(this.textField_Phone);

		JLabel label_01 = new JLabel();
		label_01.setPreferredSize(new Dimension(50,18));
		panel_new.add(label_01);

		this.btn_new = new Buttons(this.newAction, EButton.New.getString());
		this.btn_new.setPreferredSize(new Dimension(100,30));
		label_01.setPreferredSize(new Dimension(120,18));
		this.panel_new.add(btn_new);
	}

	private void complete() {
		this.session.sendProtocol("StudentManager/newMember/member/" + 
				textField_Id.getText() +"," + textField_PW.getText() +"," + textField_Name.getText() +"," + selectCampus +"," + selectCollege +"," 
				+ selectDepartment +"," + textField_Num.getText() +"," + textField_Birth.getText() +"," + textField_Phone.getText());

		VOMember vo = this.session.getMemberObject();

		this.dispose();
	}

	private void changeCombo(int flag, String action) {
		if(action.equals("ķ�۽�")) {
			this.selectCampus = this.campus.get(flag).getName();
			
			this.session.sendProtocol("LectureManager/getDirectories/college," + this.campus.get(flag).getName());
			this.college = this.session.getLectureObject();

			Vector<String> name = new Vector<String>(); 
			for(int i=0; i<this.college.size();i++) {
				name.add(this.college.get(i).getName());
			}
			this.model = new DefaultComboBoxModel(name);
			
			this.combo_college.setModel(this.model);
			this.combo_college.repaint();
			this.combo_department.repaint();
		}else if(action.equals("�ܰ�����")) {
			this.selectCollege = this.college.get(flag).getName();
			
			this.session.sendProtocol("LectureManager/getDirectories/department," + this.college.get(flag).getName());
			this.department = this.session.getLectureObject();

			Vector<String> name = new Vector<String>(); 
			for(int i=0; i<this.department.size();i++) {
				name.add(this.department.get(i).getName());
			} 
			this.model = new DefaultComboBoxModel(name);
			
			this.combo_department.setModel(this.model);
			this.combo_department.repaint();
		}else if(action.equals("�а�")) {
			this.selectDepartment = this.department.get(flag).getName();
		}
	}

	private class checkAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MemberCheck joinchk = new MemberCheck(session);
			if (!textField_Id.getText().equals("")) {
				Idrepeat = joinchk.RepetiteID(textField_Id.getText());
				if (Idrepeat)
					JOptionPane.showMessageDialog(null, "�̹� �ִ� ���̵��Դϴ�. \n ����� �Ұ����մϴ�.");
				else
					JOptionPane.showMessageDialog(null, "����� ������ ���̵��Դϴ�.");
			} else {
				JOptionPane.showMessageDialog(null, "���̵� �Է��� �ּ���.");
			}
		}
	}

	private class newAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean bPasswordMatchChk = false;
			MemberCheck membercheck = new MemberCheck(session);
			bPasswordMatchChk = membercheck.PasswordMatchChk(textField_PW.getText(), textField_PwChk.getText());

			if (textField_Name.getText().equals("") || textField_Birth.getText().equals("")
					|| textField_Phone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�� ���� ��� �Է����ּ���.");
				return;
			}
			if (!bPasswordMatchChk) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
				return;
			}
			if (Idrepeat) {
				JOptionPane.showMessageDialog(null, "���̵� �ߺ� üũ���ּ���.");
				return;
			}
			JOptionPane.showMessageDialog(null, "ȸ�����ԵǾ����ϴ�. �α��� �������� �̵��մϴ�.");
			complete();
			Reset();
		}
	}

	private class SelectAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				JComboBox jcb =(JComboBox)e.getSource();
				flag = jcb.getSelectedIndex();
				changeCombo(flag, e.getActionCommand());
		}
	}
}
