package client;

import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;


public class DirectoryPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private DirectoryList campusList;
	private DirectoryList collegeList;
	private DirectoryList departmentList;
	
	public DirectoryPanel(Session session, ListSelectionListener listSelectionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane = new JScrollPane();
		this.campusList = new DirectoryList(session);
		this.campusList.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.campusList);
		scrollpane.setPreferredSize(new Dimension(100, 180));
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.collegeList = new DirectoryList(session);
		this.collegeList.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.collegeList);
		scrollpane.setPreferredSize(new Dimension(250, 180));
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.departmentList = new DirectoryList(session);
		this.departmentList.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.departmentList);
		scrollpane.setPreferredSize(new Dimension(200, 180));
		this.add(scrollpane);
	}
	public void initialize(String ID) {
		this.refresh(null);
		
		this.campusList.initialize(ID);
		this.collegeList.initialize(ID);
		this.departmentList.initialize(ID);
	}

	public String refresh(Object source) {
		String selectName = null;
		if (source == null) {
			this.campusList.item_refresh("campus", selectName);
			selectName = this.campusList.SelectedFile();
			this.collegeList.item_refresh("college", selectName);
			selectName = this.collegeList.SelectedFile();
			this.departmentList.item_refresh("department", selectName);
			selectName = this.departmentList.SelectedFile();
		} else if (source.equals(this.campusList)) {
			selectName = this.campusList.SelectedFile();
			this.collegeList.item_refresh("college", selectName);
			selectName = this.collegeList.SelectedFile();
			this.departmentList.item_refresh("department", selectName);
			selectName = this.departmentList.SelectedFile();
		} else if (source.equals(this.collegeList)) {
			selectName = this.collegeList.SelectedFile();
			this.departmentList.item_refresh("department", selectName);
			selectName = this.departmentList.SelectedFile();
		} else if (source.equals(this.departmentList)) {
			selectName = this.departmentList.SelectedFile();
		}
		return selectName;
		
	}
}
