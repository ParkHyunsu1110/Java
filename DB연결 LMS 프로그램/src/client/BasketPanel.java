package client;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import valueobject.VOLecture;

public class BasketPanel extends JPanel {

	private Session session;
	private BasketList basketList;
	private Vector<VOLecture> voLecture;
	private boolean check = true;
	private int inform;
	private String userId;
	private String type;
	private Vector<String> addName;
	private int totalcredit;

	public BasketPanel(Session session, MouseAdapter mouseListener) {
		this.session = session;
		this.voLecture = new Vector<VOLecture>();
		this.basketList = new BasketList(this.session, mouseListener);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.basketList);
		scrollpane.setPreferredSize(new Dimension(430,500));
		this.add(scrollpane);
	}

	public void initialize(String userId, String type) {
		this.userId = userId;
		this.type = type;
		System.out.println("useriD : " + userId);
		if(check) {
			this.session.sendProtocol("LectureManager/showBasket/" + this.type + "," + this.userId);
			this.voLecture = this.session.getLectureObject();

			for( int i = 0; i < this.voLecture.size(); i++ ) {
				int credit = Integer.parseInt(this.voLecture.get(i).getCredit());
				this.totalcredit = this.totalcredit + credit;
			}

			addRows(this.voLecture, true);
			check = false;
		}
	}

	public void addRows(Vector<VOLecture> voAddLectures, boolean chk) {
		if(!chk) {
			for(int i = 0; i<voAddLectures.size(); i++) {

				this.inform = voAddLectures.get(i).getID();

				this.session.sendProtocol("LectureManager/addBasket/" + this.type + "," + this.userId + "," + this.inform);
				this.session.getLectureObject();
			}
		}

		this.basketList.add_table_rows(voAddLectures);
	}

	public void check_other(Vector<VOLecture> voLecture) {
		int credit = 0;
		for(int i = 0; i<voLecture.size(); i++) {
			credit = credit + Integer.parseInt(voLecture.get(i).getCredit());
		}
		this.totalcredit = this.totalcredit - credit;
	}

	public boolean check(Vector<VOLecture> voLectures) {
		int credit = 0;
		this.addName = new Vector<String>();
		this.addName.removeAllElements();
		for(int i = 0; i<voLectures.size(); i++) {
			credit = credit + Integer.parseInt(voLectures.get(i).getCredit());
			this.addName.add(voLectures.get(i).getName());
		}
		this.totalcredit = this.totalcredit + credit;

		this.session.sendProtocol("LectureManager/showBasket/" + this.type + "," + this.userId);
		this.voLecture = this.session.getLectureObject();

		for(int a = 0; a < this.addName.size(); a++) {
			String addingName = this.addName.get(a);
			for(int i=0; i<this.voLecture.size();i++) {
				if(addingName.equals(this.voLecture.get(i).getName())) {
					if( this.type.equals("basket")) {
						JOptionPane.showMessageDialog(null, "이미 담겨있는 과목입니다.");
						this.totalcredit = this.totalcredit - credit;
						return false;
					} else if( this.type.equals("result")) {
						JOptionPane.showMessageDialog(null, "이미 신청된 과목입니다.");
						this.totalcredit = this.totalcredit - credit;
						return false;
					}
				}
			}
		}
		if( this.totalcredit > 25 && this.type.equals("basket")) {
			JOptionPane.showMessageDialog(null, "책가방에는 최대 25학점까지 담을 수 있습니다.");
			this.totalcredit = this.totalcredit - credit;
			return false;
		}else if( this.totalcredit > 18 && this.type.equals("result")) {
			JOptionPane.showMessageDialog(null, "신청 가능하신 최대 학점은 18학점입니다.");
			this.totalcredit = this.totalcredit - credit;
			return false;
		}

		this.session.sendProtocol("LectureManager/showBasket/" + this.type + "," + this.userId);
		this.voLecture = this.session.getLectureObject();

		return true;
	}

	public Vector<VOLecture> removeSelectedLectures(String type) {
		return this.basketList.removeSelectedLectures(this.userId, type);
	}
	public Vector<VOLecture> getSelectedLectures(String type) {
		return this.basketList.getSelectedLectures(this.userId, type);
	}
	public Vector<VOLecture> getSelectedLectured() {
		return this.basketList.getSelectedLectured();
	}

}
