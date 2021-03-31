package client;

import java.awt.event.MouseAdapter;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import global.Constants.EBasketPanel;
import valueobject.VOLecture;

public class BasketList extends JTable {

	private Session session;
	private DefaultTableModel tableModel;
	private Vector<VOLecture> voLecture;

	public BasketList(Session session, MouseAdapter mouseListener) {
		this.voLecture = new Vector<VOLecture>();
		this.session = session;

		Vector<String> header = new Vector<String>();
		for (int i = 1; i < EBasketPanel.values().length; i++) {
			header.add(EBasketPanel.values()[i].getString());
		}
		this.tableModel = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) { // 더블클릭 수정 막는 것
				return false;
			}
		};
		this.addMouseListener(mouseListener);
		this.setModel(this.tableModel);
	}

	public void add_table_rows(Vector<VOLecture> lectures) {
		Vector<String> rowData;

		for(VOLecture VOLecture : lectures) {
			rowData = new Vector<String>();
			rowData.add(VOLecture.getNumber());
			rowData.add(VOLecture.getName());
			rowData.add(VOLecture.getProfessorName());
			rowData.add(VOLecture.getCredit());
			rowData.add(VOLecture.getTime());
			this.tableModel.addRow(rowData);
			this.voLecture.add(VOLecture);
		}
		
		this.clearSelection();
		this.getSelectionModel().addSelectionInterval(0, 0);
	}

	public Vector<VOLecture> getSelectedLectured(){
		Vector<VOLecture> selected_lecture = new Vector<VOLecture>();
		for(int i = this.tableModel.getRowCount() -1; i >= 0; i--) {
			if(this.isRowSelected(i)) {
				selected_lecture.add(this.voLecture.get(i));
			}			
		}
		return selected_lecture;
	}

	public Vector<VOLecture> getSelectedLectures(String userId, String type){
		Vector<VOLecture> selected_lecture = new Vector<VOLecture>();
		for(int i = this.tableModel.getRowCount() -1; i >= 0; i--) {
			if(this.isRowSelected(i)) {
				this.tableModel.removeRow(i);
				this.session.sendProtocol("LectureManager/removeBasket/" + type + "," + userId + "," + this.voLecture.get(i).getID());
				this.session.getLectureObject();
				selected_lecture.add(this.voLecture.get(i));
				this.voLecture.remove(i);
			}			
		}
		
		this.getSelectionModel().addSelectionInterval(0, 0);
		return selected_lecture;
	}

	public Vector<VOLecture> removeSelectedLectures(String userId, String type) {
		Vector<VOLecture> selected_lecture = new Vector<VOLecture>();
		for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
			if (this.isRowSelected(i)) {
				this.tableModel.removeRow(i);
				selected_lecture.add(this.voLecture.get(i));
				this.voLecture.remove(i);
			}
		}
//		for(int a=0; a < this.voLecture.size(); a++) {
//			this.inform = this.inform + this.voLecture.get(a).getNumber() + " " + this.voLecture.get(a).getName() + " " + this.voLecture.get(a).getProfessorName() + " " +
//					this.voLecture.get(a).getCredit() + " " + this.voLecture.get(a).getTime() + "\n";
//		}
//		
//		this.session.sendProtocol("LectureManager/startBasket/" + type + "_" + userId + "," + this.inform);
//		this.session.getLectureObject();
//		
//		this.inform = "";

		this.getSelectionModel().addSelectionInterval(0, 0);
		return selected_lecture;
	}
}