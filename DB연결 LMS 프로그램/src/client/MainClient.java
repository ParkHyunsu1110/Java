package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import game.Hangman;
import game.omokeGUI;
import global.Constants.EButton;
import valueobject.VOLecture;
import valueobject.VOMember;

public class MainClient {
	private Session session;

	private MyinfoFrame myinfoFrame;
	private MypageFrame mypageFrame;
	private LectureCheck lectureCheck;
	private omokeGUI gui;
	private Hangman hangman;
	private ActionHandler actionHandler;
	private ActionHandler2 logoutAction;
	private ButtonHandler buttonHandler;
	private KeyListener keyListener;
	private KeyHandler2 keyListener2;
	private JFrameWindowClosingEventHandler windowEvent;
	public LoginFrame loginFrame;
	public JoinFrame joinFrame;
	private FindFrame findFrame;
	private MainFrame mainFrame;
	private String userName;
	private String userId;
	private boolean flag = true;

	public MainClient(Session session) {
		this.session = session;
	}
	public void initialize() {
		this.buttonHandler = new ButtonHandler();
		this.actionHandler = new ActionHandler();  
		this.keyListener = new KeyHandler();
		this.keyListener2 = new KeyHandler2();
		this.windowEvent = new JFrameWindowClosingEventHandler();
		this.loginFrame = new LoginFrame(this.actionHandler,this.windowEvent, this.keyListener, this.keyListener2);
		this.findFrame = new FindFrame(this.session);
		this.myinfoFrame = new MyinfoFrame(this.session);
	}

	public void run() {
		login();
	}

	private void login_success() {
		VOMember voMember = this.loginFrame.validationcheck(this.session);
		this.userName = voMember.getName();
		this.userId = voMember.getUserId();
		
		if(voMember.getIDcheck()) {
			JOptionPane.showMessageDialog(null, userName + "�� ȯ���մϴ�.");
			this.loginFrame.dispose();

			this.mainFrame = new MainFrame(this.session, this.logoutAction, this.buttonHandler, userId, this.windowEvent);
			this.mainFrame.initialize(this.userId);
			this.mainFrame.setVisible(true);
			this.mainFrame.setLocationRelativeTo(null);
		}else {
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}
	public void login() {
		this.loginFrame.setVisible(true);
		this.loginFrame.setLocationRelativeTo(null);
	}

	public void join() {
		this.session.sendProtocol("LectureManager/getDirectories/campus");
		Vector<VOLecture> campus = this.session.getLectureObject();

		this.joinFrame = new JoinFrame(this.session, campus);

		this.joinFrame.setVisible(true);
		this.joinFrame.setLocationRelativeTo(null);
	}

	public void windowClose() {		
		this.session.sendProtocol("quit");

		JOptionPane.showMessageDialog(null, "�������� ������ ���� LMS�� �����մϴ�.", "Ȯ�θ޽���", JOptionPane.OK_OPTION);
	}

	private void reLogin() {
		this.loginFrame = new LoginFrame(this.actionHandler,this.windowEvent, this.keyListener, this.keyListener2);
		this.loginFrame.setLocationRelativeTo(null);
		this.loginFrame.setVisible(true);
	}

	class ActionHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			mainFrame.dispose();
			reLogin();
		}
	}
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lectureCheck = new LectureCheck(session, userId);
			String bt = e.getActionCommand(); // ���� ����ȯ
			if (bt.equals(EButton.Logout.getString())) {
				int result = JOptionPane.showConfirmDialog(null, "�α׾ƿ��Ͻðڽ��ϱ�?", "Ȯ�θ޽���", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					mainFrame.dispose();
					reLogin();
				}				
			}else if (bt.equals(EButton.Inform.getString())) {
				myinfoFrame.initialize(userId);
				myinfoFrame.setVisible(true);
				myinfoFrame.setLocationRelativeTo(null);
			} else if (bt.equals(EButton.Mypage.getString())) {
				mypageFrame = new MypageFrame(userId, session);
				mypageFrame.setVisible(true);
				mypageFrame.setLocationRelativeTo(null);
			} else if (bt.equals(EButton.Grade.getString())) {
				JOptionPane.showMessageDialog(null, "������ �����ϴ�.", "�˸��޽���", JOptionPane.ERROR_MESSAGE);
			} else if(bt.equals(EButton.Check.getString())) {
				JOptionPane.showMessageDialog(null, "������", "�Ϸ�޽���", JOptionPane.OK_OPTION);
//				if(flag) {
//					lectureCheck.setVisible(true);
//					lectureCheck.setLocationRelativeTo(null);
//					flag = false;
//				}else {
//					JOptionPane.showMessageDialog(null, "�����򰡸�  �̹� �Ϸ��ϼ̽��ϴ�.", "�Ϸ�޽���", JOptionPane.OK_OPTION);
//				}

			}	
			if(e.getActionCommand().equals("�������")) {
				gui = new omokeGUI("�������");
				gui.setVisible(true);
				gui.setLocationRelativeTo(null);
			} else if(e.getActionCommand().equals("��ǰ���")) {
				hangman = new Hangman("��ǰ���");
				hangman.setVisible(true);
				hangman.setLocationRelativeTo(null);
			}
		}
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) { 
			if(actionEvent.getActionCommand().equals(EButton.Reset.getString())) {
				loginFrame.textField_Id.setText("");
				loginFrame.textField_PW.setText("");
			}else if(actionEvent.getActionCommand().equals(EButton.Login.getString())) {
				login_success();
			}else if(actionEvent.getActionCommand().equals(EButton.Find.getString())) {
				findFrame.setVisible(true);
				findFrame.setLocationRelativeTo(null);
			}else if(actionEvent.getActionCommand().equals(EButton.New.getString())) {
				join();
			}
		}
	}

	class KeyHandler implements KeyListener {
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				login_success();
			}
		}
		public void keyReleased(KeyEvent event) {
		}
		public void keyTyped(KeyEvent event) {
		}
	}
	class KeyHandler2 implements KeyListener {
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == 27) {
				loginFrame.dispose();
			}
		}
		public void keyReleased(KeyEvent event) {
		}
		public void keyTyped(KeyEvent event) {
		}
	}
	class JFrameWindowClosingEventHandler extends WindowAdapter { 
		public void windowClosing(WindowEvent e) { 
			JFrame frame = (JFrame)e.getWindow(); 
			frame.dispose(); 
			windowClose();
		} 
	}
}
