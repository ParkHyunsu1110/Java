package client;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ELecture;
import global.Constants.ELecturePanel;
import valueobject.VOLecture;

public class LectureTable extends JPanel {
	private Session session;
	private Vector<VOLecture> voLecture;
	private LectureList lectureList;
	public LectureTable(Session session, MouseAdapter mouseListener) {
		this.session = session;
		this.lectureList = new LectureList(mouseListener);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.lectureList);
		this.setLayout(new BorderLayout());
		this.add(scrollpane);
	}
	public void initialize(String ID) {
		
	}
	public void lecture_refresh(String selectedName) throws FileNotFoundException{
		this.session.sendProtocol("LectureManager/getLectures/" + selectedName);
		this.voLecture = this.session.getLectureObject();

		this.lectureList.add_table_rows(this.voLecture);
	}
	public Vector<VOLecture> getSelectedLectures() {
		return this.lectureList.getSelectedLectures();
	}
	public class LectureList extends JTable {
		private DefaultTableModel tableModel;

		public LectureList(MouseAdapter mouseListener) {
			this.getTableHeader().setReorderingAllowed(false);
			this.getTableHeader().setResizingAllowed(false);

			Vector<String> header = new Vector<String>();
			for(int i = 1; i < ELecturePanel.values().length; i++ ) {
				header.add(ELecturePanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.addMouseListener(mouseListener);
			this.setModel(this.tableModel);
		}

		public void add_table_rows(Vector<VOLecture> lectures) {
			this.tableModel.setRowCount(0);
			Vector<String> rowData;

			for(VOLecture eLecture : lectures) {
				rowData = new Vector<String>();
				rowData.add(eLecture.getNumber());
				rowData.add(eLecture.getName());
				rowData.add(eLecture.getProfessorName());
				rowData.add(eLecture.getCredit());
				rowData.add(eLecture.getTime());
				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

		public Vector<VOLecture> getSelectedLectures(){
			Vector<VOLecture> selected_lecture = new Vector<VOLecture>();
			for(int i = 0; i < this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					selected_lecture.add(voLecture.get(i));
				}
			}
			return selected_lecture;
		}
	}
}
