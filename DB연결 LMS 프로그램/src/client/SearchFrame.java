package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ELecture;
import global.Buttons;
import global.Constants.EMovePanel;
import global.Constants.ESearchPanel;
import valueobject.VOLecture;

public class SearchFrame extends JFrame {

	Session session;
	SearchList searchList;
	Buttons btn_basket, btn_result;
	
	public SearchFrame(Session session, ActionListener actionHandler) {

		this.session = session;
		this.searchList = new SearchList(this.session);
		this.setSize(400, 400);
		
		JPanel panel_main = new JPanel();
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.Y_AXIS));
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.searchList);
		this.setLayout(new BorderLayout());
		panel_main.add(scrollpane);
		
		JPanel panel_btn = new JPanel();
		panel_btn.setLayout(new BoxLayout(panel_btn, BoxLayout.X_AXIS));
		btn_basket = new Buttons(actionHandler, EMovePanel.Basket.getString());
		panel_btn.add(btn_basket);
		
		panel_btn.add(Box.createRigidArea(new Dimension(20,0)));
		
		btn_result = new Buttons(actionHandler, EMovePanel.Result.getString());
		panel_btn.add(btn_result);
		panel_main.add(panel_btn);
		
		this.add(panel_main);
	}
	public Vector<VOLecture> getSearchLectures(){
		return this.searchList.getSearchLectures();
	}
	public void initialize(Vector<VOLecture> lectures) {
		this.searchList.add_table_rows(lectures);
	}
	
	public class SearchList extends JTable {
		private Session session;
		private DefaultTableModel tableModel;
		private Vector<VOLecture> voLecture;
		public SearchList(Session session) {
			this.session = session;
			this.voLecture = new Vector<VOLecture>();
			this.getTableHeader().setReorderingAllowed(false);
			this.getTableHeader().setResizingAllowed(false);

			Vector<String> header = new Vector<String>();
			for(int i = 0; i < ESearchPanel.values().length; i++ ) {
				header.add(ESearchPanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			this.setModel(this.tableModel);
		}
		public void add_table_rows(Vector<VOLecture> lectures) {
			for(int i = 0; i<lectures.size(); i++) {
				this.voLecture.add(lectures.get(i));
			}
			this.tableModel.setRowCount(0);
			Vector<String> rowData;

			for(VOLecture voLecture : lectures) {
				rowData = new Vector<String>();
				rowData.add(voLecture.getName());
				rowData.add(voLecture.getCredit());
				rowData.add(voLecture.getTime());
				
				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
		
		public Vector<VOLecture> getSearchLectures(){
			Vector<VOLecture> selected_lecture = new Vector<VOLecture>();
			for(int i = 0; i < this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					selected_lecture.add(this.voLecture.get(i));
				}
			}
			return selected_lecture;
		}
	}
}
