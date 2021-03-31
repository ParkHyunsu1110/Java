package client;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import entity.ELecture;
import valueobject.VOLecture;

public class DirectoryList<E> extends JList<String> {

	private Session session;
	private static final long serialVersionUID = 1L;
	private Vector<VOLecture> directories;
	private Vector<String> listData;

	public DirectoryList(Session session) {
		this.session = session;
		this.listData = new Vector<String>();
		this.setListData(listData);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void initialize(String ID) {

	}

	public void item_refresh(String type, String selectedName) {
		this.listData.clear();
		if(type == null) {
			return;
		}
		this.session.sendProtocol("LectureManager/getDirectories/" + type + "," + selectedName);
		this.directories = this.session.getLectureObject();			

		for(VOLecture voDirectory : directories){
			this.listData.add(voDirectory.getName());
		}
		this.setSelectedIndex(0);
		this.updateUI();

	}

	public String SelectedFile() {
		String fileName = this.directories.get(this.getSelectedIndex()).getName();

		return fileName;
	}

}
