package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import global.Constants.EMovePanel;
import valueobject.VOLecture;

public class MainPanel extends JPanel {
	
	private Session session;
	public SelectionPanel selectionPanel;
	public BasketPanel basketPanel;
	public BasketPanel resultPanel;
	public MovePanel movePanel1;
	public MovePanel movePanel2;
	public ButtonPanel buttonPanel;
	private Vector<VOLecture> voLecture_basket;
	private Vector<VOLecture> voLecture_result;
	ActionListener actionHandler;
	MyMouseListener1 mouseListener1;
	MyMouseListener2 mouseListener2;
	public JPanel panel_basket, panel_result, panel_button, panel_game;
	public JLabel label_icon, label_txt, label_name, label_basket, label_result, label_credit_basket, label_credit_result;
	public int totalcredit_basket;
	public int totalcredit_result;
	private int credit;

	public MainPanel(Session session, ActionListener logoutAction, ActionListener buttonHandler, String userId) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.session= session;
		
		this.session.sendProtocol("LectureManager/showBasket/basket," + userId);
		this.voLecture_basket = this.session.getLectureObject();
		
		for( int i = 0; i < this.voLecture_basket.size(); i++ ) {
			int now_credit_basket = Integer.parseInt(this.voLecture_basket.get(i).getCredit());
			this.totalcredit_basket = this.totalcredit_basket + now_credit_basket;
		}
		
		this.session.sendProtocol("LectureManager/showBasket/result," + userId);
		this.voLecture_result = this.session.getLectureObject();
		for( int i = 0; i < this.voLecture_result.size(); i++ ) {
			int now_credit_result = Integer.parseInt(this.voLecture_result.get(i).getCredit());
			this.totalcredit_result = this.totalcredit_result + now_credit_result;
		}
		
		this.mouseListener1 = new MyMouseListener1();
		this.mouseListener2 = new MyMouseListener2();
		this.actionHandler = new ActionHandler();

		this.label_name = new JLabel();
		this.label_name.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));

		this.selectionPanel= new SelectionPanel(this.session, this.mouseListener1, this.actionHandler);
		this.add(this.selectionPanel);

		this.movePanel1 = new MovePanel(actionHandler);
		this.movePanel1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.add(this.movePanel1);

		this.panel_basket = new JPanel();
		this.panel_result = new JPanel();
		this.panel_button = new JPanel();

		this.label_basket = new JLabel("    책가방 내역   ");
		this.label_basket.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.label_basket.setFont(new Font("DX피오피", Font.BOLD, 20));
		this.label_basket.setBackground(Color.WHITE);
		this.panel_basket.add(this.label_basket);

		this.label_credit_basket = new JLabel(" 학점 : " + this.totalcredit_basket );
		this.label_credit_basket.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.label_credit_basket.setFont(new Font("DX피오피", Font.BOLD, 15));
		this.panel_basket.add(this.label_credit_basket);

		this.basketPanel = new BasketPanel(this.session, this.mouseListener2);
		this.basketPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.panel_basket.add(this.basketPanel);
		this.add(this.panel_basket);

		this.movePanel2 = new MovePanel(actionHandler);
		this.movePanel2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.add(this.movePanel2);

		this.label_result = new JLabel("   수강신청 내역   ");
		this.label_result.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.label_result.setFont(new Font("DX피오피", Font.BOLD, 20));
		this.panel_result.add(this.label_result);

		this.label_credit_result = new JLabel(" 학점 : " + this.totalcredit_result );
		this.label_credit_result.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.label_credit_result.setFont(new Font("DX피오피", Font.BOLD, 15));
		this.panel_result.add(this.label_credit_result);

		this.resultPanel = new BasketPanel(this.session, null);
		this.resultPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2)));
		this.panel_result.add(this.resultPanel);
		this.add(this.panel_result);

		this.buttonPanel = new ButtonPanel(label_name, logoutAction, buttonHandler, userId);
		this.panel_button.add(this.buttonPanel);
		this.add(this.panel_button);
	}

	public void initialize(String ID) {
		this.label_name.setText(ID + "님 환영합니다.");
		this.label_name.setFont(new Font("DX피오피", Font.BOLD, 20));
		this.selectionPanel.initialize(ID);
		this.basketPanel.initialize(ID, "basket");
		this.resultPanel.initialize(ID, "result");
	}

	public void finish(String ID) throws IOException {
		this.selectionPanel.finish(ID);
	}

	private void removeSelectedLectures() {
		Vector<VOLecture> selectedLectures = this.basketPanel.getSelectedLectures("basket");
		this.basketPanel.check_other(selectedLectures);
		credit = 0;
		for(int i = 0; i<selectedLectures.size(); i++) {
			credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
		}
		this.totalcredit_basket = this.totalcredit_basket - this.credit;
		this.label_credit_basket.setText(" 학점 : " +Integer.toString(this.totalcredit_basket));
	}
	private void moveLecturesToBasket() {
		Vector<VOLecture> selectedLectures = this.selectionPanel.getSelectedLectures();// 끌어오고
		boolean chk = this.basketPanel.check(selectedLectures);
		if(chk) {
			credit = 0;
			this.basketPanel.addRows(selectedLectures, false);
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_basket = this.totalcredit_basket + this.credit;
			this.label_credit_basket.setText(" 학점 : " +Integer.toString(this.totalcredit_basket));
		}
	}
	private void moveSearchToBasket() {
		Vector<VOLecture> selectedLectures = this.selectionPanel.getSearchLectures();// 끌어오고
		boolean chk = this.basketPanel.check(selectedLectures);
		if(chk) {
			credit = 0;
			this.basketPanel.addRows(selectedLectures, false);
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_basket = this.totalcredit_basket + this.credit;
			this.label_credit_basket.setText(" 학점 : " +Integer.toString(this.totalcredit_basket));
		}
	}
	private void moveLecturesToResult() {
		Vector<VOLecture> selectedLectures = this.selectionPanel.getSelectedLectures();// 끌어오고
		boolean chk = this.resultPanel.check(selectedLectures);
		if(chk) {
			this.resultPanel.addRows(selectedLectures, false);
			credit = 0;
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_result = this.totalcredit_result + this.credit;
			this.label_credit_result.setText(" 학점 : " +Integer.toString(this.totalcredit_result));
		}
	}
	private void moveSearchToResult() {
		Vector<VOLecture> selectedLectures = this.selectionPanel.getSearchLectures();// 끌어오고
		boolean chk = this.resultPanel.check(selectedLectures);
		if(chk) {
			this.resultPanel.addRows(selectedLectures, false);
			credit = 0;
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_result = this.totalcredit_result + this.credit;
			this.label_credit_result.setText(" 학점 : " +Integer.toString(this.totalcredit_result));
		}
	}
	private void moveBasketToResult() {
		Vector<VOLecture> selectedLectures = this.basketPanel.getSelectedLectured();
		boolean chk = this.resultPanel.check(selectedLectures);
		if(chk) {
			this.basketPanel.check_other(selectedLectures);
			selectedLectures = this.basketPanel.getSelectedLectures("basket");
			
			this.resultPanel.addRows(selectedLectures, false);
			credit = 0;
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_result = this.totalcredit_result + this.credit;
			this.totalcredit_basket = this.totalcredit_basket - this.credit;
			this.label_credit_result.setText(" 학점 : " +Integer.toString(this.totalcredit_result));
			this.label_credit_basket.setText(" 학점 : " +Integer.toString(this.totalcredit_basket));
		}
	}
	private void moveResultToBasket() {
		Vector<VOLecture> selectedLectures = this.resultPanel.getSelectedLectured();
		boolean chk = this.basketPanel.check(selectedLectures);
		if(chk) {
			this.resultPanel.check_other(selectedLectures);
			selectedLectures = this.resultPanel.getSelectedLectures("result");
			this.basketPanel.addRows(selectedLectures, false);
			credit = 0;
			for(int i = 0; i<selectedLectures.size(); i++) {
				credit = credit + Integer.parseInt(selectedLectures.get(i).getCredit());
			}
			this.totalcredit_basket = this.totalcredit_basket + this.credit;
			this.totalcredit_result = this.totalcredit_result - this.credit;
			this.label_credit_basket.setText(" 학점 : " +Integer.toString(this.totalcredit_basket));
			this.label_credit_result.setText(" 학점 : " + Integer.toString(this.totalcredit_result));
		}
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource().equals(movePanel1.getLeftButton())) {
				int result = JOptionPane.showConfirmDialog(null, "책가방에서 강의를 삭제하시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					removeSelectedLectures();
				}
			}else if (event.getActionCommand().equals(EMovePanel.Basket.getString())){
				int result = JOptionPane.showConfirmDialog(null, "강의를 책가방에 담으시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveSearchToBasket();
				}	
			}else if (event.getSource().equals(movePanel1.getRightButton())) {
				int result = JOptionPane.showConfirmDialog(null, "강의를 책가방에 담으시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveLecturesToBasket();
				}				
			} else if (event.getSource().equals(movePanel2.getLeftButton())) {
				int result = JOptionPane.showConfirmDialog(null, "신청된 강의를 삭제하시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveResultToBasket();
				}
			} else if (event.getSource().equals(movePanel2.getRightButton())) {
				int result = JOptionPane.showConfirmDialog(null, "강의를 신청하시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveBasketToResult();
				}
			} else if (event.getActionCommand().equals(EMovePanel.Result.getString())) {
				int result = JOptionPane.showConfirmDialog(null, "강의를 신청하시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveSearchToResult();
				}
			} else if (event.getSource().equals(selectionPanel.getrightpassButton())) {
				int result = JOptionPane.showConfirmDialog(null, "강의를 바로 신청하시겠습니까?", "확인메시지", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(result == JOptionPane.YES_OPTION) {
					moveLecturesToResult();
				}
			}
		}
	}
	private class MyMouseListener1 extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) { 
				moveLecturesToBasket();
			}
		}
	}
	private class MyMouseListener2 extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) { 
				moveBasketToResult();
			}
		}
	}
}
