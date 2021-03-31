package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import global.Buttons;
import global.Constants.EButton;
import valueobject.VOLecture;

public class LectureCheck extends JFrame {
	private Vector<VOLecture> voLecture;
	private Session session;
	private Vector<String> lecture_name;
	private String userId;
	private String array[] = {"1","2","3"};
	private String radio_name[] = {"1점", "2점", "3점", "4점", "5점"}; 
	private JRadioButton radio[] = new JRadioButton[5];
	private JComboBox combo_lecture;
	private JLabel label_q1, label_q2, label_q3;
	private JPanel panel_all,panel_top, panel_center, panel_bottom, panel_button;
	Action action;
	private int flag;
	public boolean check = true;
	SaveAction saveAction;
	private Buttons btn_okay;

	public LectureCheck(Session session, String userId) {
		this.session = session;
		this.action = new Action();
		this.saveAction = new SaveAction();
		this.btn_okay = new Buttons(this.saveAction, EButton.Okay.getString());
		this.userId = userId;

		this.setSize(700,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.session.sendProtocol("LectureManager/showBasket/result," + userId);
		this.voLecture = this.session.getLectureObject();

		System.out.println(this.voLecture.size());
		
		lecture_name = new Vector<String>(); 
		for(int i=0; i<voLecture.size();i++) {
			lecture_name.add(voLecture.get(i).getName());
		}
		this.combo_lecture = new JComboBox(lecture_name);
		this.combo_lecture.addActionListener(this.action);

		this.panel_all = new JPanel();
		this.setContentPane(this.panel_all);
		this.panel_all.setLayout(new BorderLayout());
		this.panel_top = new JPanel();
		this.panel_top.add(this.combo_lecture);
		this.panel_all.add(this.panel_top, BorderLayout.NORTH);

		this.label_q1 = new JLabel("Q1. '" + lecture_name.get(0) + "' 강의의 만족도를 선택해주세요.");
		this.label_q1.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		this.label_q2 = new JLabel("Q2. '" + lecture_name.get(0) + "' 강의는 " + userId + "님에게 도움이 된 정도를 선택해주세요.");
		this.label_q2.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		this.label_q3 = new JLabel("Q3 '" + lecture_name.get(0) + "' 강의를 다른 학생들에게 추천하고 싶은 정도를 선택해주세요.");
		this.label_q3.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		place();
	}
	public void place() {		
		this.panel_center = new JPanel();
		this.panel_all.add(Box.createRigidArea(new Dimension(0,10)));
		this.panel_center.setLayout(new BoxLayout(this.panel_center, BoxLayout.Y_AXIS));
		this.panel_center.add(this.label_q1);
		this.panel_center.add(Box.createRigidArea(new Dimension(0,10)));
		button();
		this.panel_center.add(this.panel_button);

		this.panel_center.add(this.label_q2);
		this.panel_center.add(Box.createRigidArea(new Dimension(0,15)));
		button();
		this.panel_center.add(this.panel_button);

		this.panel_center.add(this.label_q3);
		this.panel_center.add(Box.createRigidArea(new Dimension(0,10)));
		button();
		this.panel_center.add(this.panel_button);
		this.panel_center.add(this.btn_okay);
		this.panel_all.add(this.panel_center, BorderLayout.CENTER);
	}
	public void button() {
		ButtonGroup group = new ButtonGroup();
		this.panel_button = new JPanel();
		for(int i=0; i<radio.length; i++){
			radio[i] = new JRadioButton(radio_name[i]);
			group.add(radio[i]);
			this.panel_button.add(radio[i]);
		}
	}
	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox jcb =(JComboBox)e.getSource();
			flag = jcb.getSelectedIndex();
			label_q1.setText("Q1. '" + lecture_name.get(flag) + "' 강의의 만족도를 선택해주세요.");
			label_q2.setText("Q2. '" + lecture_name.get(flag) + "' 강의는 " + userId + "님에게 도움이 된 정도를 선택해주세요.");
			label_q3.setText("Q3 '" + lecture_name.get(flag) + "' 강의를 다른 학생들에게 추천하고 싶은 정도를 선택해주세요.");
		}
	}
	private class SaveAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "강의평가가 완료되었습니다.", "완료메시지", JOptionPane.INFORMATION_MESSAGE);
			out();
		}
	}
	private void out(){
		this.dispose();
	}
	public boolean initialize() {
		return check;
	}
}