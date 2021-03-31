package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import dao.DAOBasket;
import dao.DAOLecture;
import entity.ELecture;
import server.Session;
import valueobject.VOLecture;

public class LectureManager extends Session{

	private DAOLecture daoLecture;
	private DAOBasket daoBasket;

	public LectureManager() {
		this.daoLecture = new DAOLecture();
		this.daoBasket = new DAOBasket();
	}

	public Vector<VOLecture> getDirectories(String infor) throws FileNotFoundException{
		String[] directoryinfor = infor.split(",");
		Vector<ELecture> items;
		if(directoryinfor[0].equals("campus")) {
			items = this.daoLecture.getDirectories(directoryinfor[0], null);
		}else {
			items = this.daoLecture.getDirectories(directoryinfor[0], directoryinfor[1]);
		}
		Vector<VOLecture> voLecture = new Vector<VOLecture>();

		for(int i = 0; i<items.size(); i++) {
			VOLecture vo = new VOLecture();
			vo.setID(items.get(i).getID());
			vo.setName(items.get(i).getName());
			vo.setUpperID(items.get(i).getUpperID());
			
			voLecture.add(vo);
		}
		return voLecture;
	}

	public Vector<VOLecture> getLectures(String selectedName) throws FileNotFoundException{
		Vector<ELecture> items = this.daoLecture.getLectures(selectedName);
		Vector<VOLecture> voLecture = new Vector<VOLecture>();

		for(int i = 0; i<items.size(); i++) {
			VOLecture vo = new VOLecture();
			vo.setUpperID(items.get(i).getUpperID());
			vo.setID(items.get(i).getID());
			vo.setNumber(items.get(i).getNumber());
			vo.setName(items.get(i).getName());
			vo.setProfessorName(items.get(i).getProfessorName());
			vo.setCredit(items.get(i).getCredit());
			vo.setTime(items.get(i).getTime());
			
			voLecture.add(vo);
		}
		return voLecture;
	}

	public Vector<VOLecture> showBasket(String infor) throws IOException {
		String[] basket_infor = infor.split(",");
		Vector<ELecture> items = this.daoBasket.show(basket_infor);
		Vector<VOLecture> voLecture = new Vector<VOLecture>();
		
		for(int i = 0; i<items.size(); i++) {
			VOLecture vo = new VOLecture();
			vo.setID(items.get(i).getID());
			vo.setUpperID(items.get(i).getUpperID());
			vo.setNumber(items.get(i).getNumber());
			vo.setName(items.get(i).getName());
			vo.setProfessorName(items.get(i).getProfessorName());
			vo.setCredit(items.get(i).getCredit());
			vo.setTime(items.get(i).getTime());
			
			voLecture.add(vo);
		}
		return voLecture;
	}

	public Vector<VOLecture> removeBasket(String infor) throws IOException{
		String[] basket_infor = infor.split(",");

		Vector<ELecture> items = this.daoBasket.remove(basket_infor);
		Vector<VOLecture> voLecture = new Vector<VOLecture>();

		for(int i = 0; i<items.size(); i++) {
			VOLecture vo = new VOLecture();
			vo.setID(items.get(i).getID());
			vo.setUpperID(items.get(i).getUpperID());
			vo.setNumber(items.get(i).getNumber());
			vo.setName(items.get(i).getName());
			vo.setProfessorName(items.get(i).getProfessorName());
			vo.setCredit(items.get(i).getCredit());
			vo.setTime(items.get(i).getTime());
			
			voLecture.add(vo);
		}
		return voLecture;	
	}

	public Vector<VOLecture> addBasket(String infor) throws IOException{
		String[] basket_infor = infor.split(",");
		Vector<ELecture> items = this.daoBasket.add(basket_infor);

		Vector<VOLecture> voLecture = new Vector<VOLecture>();

		for(int i = 0; i<items.size(); i++) {
			VOLecture vo = new VOLecture();
			vo.setNumber(items.get(i).getNumber());
			vo.setName(items.get(i).getName());
			vo.setProfessorName(items.get(i).getProfessorName());
			vo.setCredit(items.get(i).getCredit());
			vo.setTime(items.get(i).getTime());
			
			voLecture.add(vo);
		}
		return voLecture;
	}
}
