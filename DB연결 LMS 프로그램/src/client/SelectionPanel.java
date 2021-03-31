package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import global.Buttons;
import global.Constants.EMovePanel;
import valueobject.VOLecture;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Session session;
	private DirectoryPanel directoryPanel;
	private LectureTable lectureTable;
	private JTextField txt_search;
	private SearchFrame searchFrame;
	Buttons btn_rightpass;
	KeyHandler keyHandler;
	ActionSearch actionsearch;

	public SelectionPanel(Session session, MouseAdapter mouseListener, ActionListener actionHandler) {
		this.session = session;
		this.searchFrame = new SearchFrame(this.session, actionHandler);
		this.keyHandler = new KeyHandler();
		this.actionsearch = new ActionSearch();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ListSelectionListener listSelectionListener = new ListSelectionHandler();
		this.directoryPanel = new DirectoryPanel(this.session, listSelectionListener);
		this.add(this.directoryPanel);
		this.lectureTable = new LectureTable(this.session, mouseListener);
		this.add(this.lectureTable);

		JPanel panel_search = new JPanel();
		panel_search.setLayout(new BoxLayout(panel_search, BoxLayout.X_AXIS));

		this.txt_search = new JTextField();
		this.txt_search.setColumns(10);
		this.txt_search.setToolTipText("강의명 검색");
		this.txt_search.addKeyListener(this.keyHandler);
		panel_search.add(this.txt_search);

		JButton btn_search = new JButton(new ImageIcon("img/searching.jpg"));
		btn_search.setToolTipText("강의명 검색");
		btn_search.addActionListener(this.actionsearch);
		panel_search.add(btn_search);

		this.add(panel_search);

		this.btn_rightpass = new Buttons(actionHandler, EMovePanel.Rightpass.getString());
		this.btn_rightpass.setActionCommand(EMovePanel.RightpassButton.getString());
		this.add(this.btn_rightpass);
	}
	public Buttons getrightpassButton() {
		return btn_rightpass;
	}
	public void initialize(String ID) {
		this.directoryPanel.initialize(ID);
		this.lectureTable.initialize(ID);
	}
	public void finish(String ID) {

	}
	public Vector<VOLecture> getSelectedLectures(){
		return this.lectureTable.getSelectedLectures();
	}
	public Vector<VOLecture> getSearchLectures(){
		return this.searchFrame.getSearchLectures();
	}
	private class ListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			String selectedName = directoryPanel.refresh(e.getSource());
			try {
				lectureTable.lecture_refresh(selectedName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	private void showresult() {
		boolean flag = false;
		Vector<VOLecture> lectures = new Vector<VOLecture>();
		Vector<VOLecture> items = new Vector<VOLecture>();

		this.session.sendProtocol("LectureManager/getLectures/all");
		items = this.session.getLectureObject();

		for(int i = 0; i<items.size(); i++) {
			if(items.get(i).getName().contains(txt_search.getText())) {
				lectures.add(items.get(i));
				flag = true;
			}
		}

		if(flag) {
			this.searchFrame.initialize(lectures);
			this.searchFrame.setVisible(true);
			this.searchFrame.setLocationRelativeTo(null);
		}else {
			JOptionPane.showMessageDialog(null, "해당하는 강의가 존재하지 않습니다.", "알림메시지", JOptionPane.OK_OPTION);
		}
		this.txt_search.setText("");
	}
	private class ActionSearch implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(txt_search.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "강의명을 입력해 주십시오.");
			} else {
				showresult();
			}
		}	
	}
	private class KeyHandler implements KeyListener {
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				if(txt_search.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "강의명을 입력해 주십시오.");
				} else {
					showresult();
				}
			}
		}
		public void keyReleased(KeyEvent event) {
		}
		public void keyTyped(KeyEvent event) {
		}
	}
}
