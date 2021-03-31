package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import global.Buttons;
import global.Constants.EButton;
import valueobject.VOMember;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Buttons btn_login, btn_init, btn_new, btn_find;
	public JPasswordField textField_PW;
	public JTextField textField_Id;
	private JLabel label_txt, label_icon, label_id, label_pw;
	String change = "";

	public LoginFrame(ActionListener actionHandler, WindowAdapter windowEvent, KeyListener keyHandler, KeyListener keyHandler2) {
		super("로그인");
		this.setSize(350, 320);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.addWindowListener(windowEvent);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/mju_title.jpg");
		this.setIconImage(img);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.label_icon = new JLabel(new ImageIcon("img/mju.jpg"));
		this.label_txt = new JLabel("명지대학교");
		this.label_txt.setFont(new Font("DX피오피", Font.BOLD, 35));

		EtchedBorder eborder = new EtchedBorder();
		this.label_icon.setBorder(eborder);
		this.label_icon.setToolTipText("명지대학교");

		JPanel panel_top = new JPanel();
		panel_top.add(this.label_icon);
		panel_top.add(this.label_txt);

		JPanel panel_center = new JPanel();
		panel_center.setSize(new Dimension(350,300));
		JPanel panel_id = new JPanel();
		this.label_id = new JLabel("ID   : ");
		this.label_id.setFont(new Font("DX피오피", Font.BOLD, 15));
		panel_id.add(this.label_id);
		this.textField_Id = new JTextField(12);
		this.textField_Id.addKeyListener(keyHandler);
		this.textField_Id.addKeyListener(keyHandler2);
		panel_id.add(this.textField_Id);

		JPanel panel_pw = new JPanel();
		this.label_pw = new JLabel("PW  : ");
		this.label_pw.setFont(new Font("DX피오피", Font.BOLD, 15));
		panel_pw.add(this.label_pw);
		this.textField_PW = new JPasswordField(12);
		this.textField_PW.addKeyListener(keyHandler);
		this.textField_PW.addKeyListener(keyHandler2);
		panel_pw.add(this.textField_PW);

		panel_center.add(panel_id, BorderLayout.CENTER);
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(80,30));
		panel_center.add(label, BorderLayout.EAST);
		panel_center.add(panel_pw, BorderLayout.CENTER);
		this.btn_login = new Buttons(actionHandler,EButton.Login.getString());
		this.btn_login.setPreferredSize(new Dimension(80,30));
		panel_center.add(this.btn_login, BorderLayout.EAST);

		JPanel panel_btn = new JPanel();
		this.btn_init = new Buttons(actionHandler, EButton.Reset.getString());
		this.btn_init.setPreferredSize(new Dimension(70,30));
		panel_btn.add(this.btn_init);

		this.btn_find = new Buttons(actionHandler, EButton.Find.getString());
		panel_btn.add(this.btn_find);

		this.btn_new = new Buttons(actionHandler, EButton.New.getString());
		panel_btn.add(this.btn_new);
		panel_center.add(panel_btn, BorderLayout.SOUTH);

		this.add(panel_top, BorderLayout.NORTH);
		this.add(panel_center, BorderLayout.CENTER);
	}

	public VOMember validationcheck(Session session) {
		String ID = textField_Id.getText();
		String password = textField_PW.getText();

		session.sendProtocol("StudentManager/getMember/member/" + ID + "," + password);
		VOMember voMember = session.getMemberObject();
		return voMember;
	}
}