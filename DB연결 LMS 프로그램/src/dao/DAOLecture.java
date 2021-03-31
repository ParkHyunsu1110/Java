package dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import entity.ELecture;
import global.DBConnect;

public class DAOLecture {

	public Vector<ELecture> getLectures(String selectedName) throws FileNotFoundException {
		Vector<ELecture> items = new Vector<ELecture>();
		DBConnect  db = new DBConnect();
		int upperId = 0;
		
		if(selectedName.equals("all")) {
			try {
				db.select("select * from lecture");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					ELecture eLecture= new ELecture();
					eLecture.setID(db.rs.getInt("ID"));
					eLecture.setUpperID(db.rs.getInt("department_ID"));
					eLecture.setName(db.rs.getString("name"));
					eLecture.setNumber(db.rs.getString("number"));
					eLecture.setCredit(db.rs.getString("credit"));
					eLecture.setProfessorName(db.rs.getString("professor"));
					eLecture.setTime(db.rs.getString("time"));
					items.add(eLecture);
				}
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				db.select("select * from department");
				while(db.rs.next()) {
					if(db.rs.getString("name").equals(selectedName)) {
						upperId = db.rs.getInt("ID");
						break;
					}
				}
				
				db.select("select * from lecture");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getInt("department_ID") == upperId) {
						ELecture eLecture= new ELecture();
						eLecture.setID(db.rs.getInt("ID"));
						eLecture.setUpperID(db.rs.getInt("department_ID"));
						eLecture.setName(db.rs.getString("name"));
						eLecture.setNumber(db.rs.getString("number"));
						eLecture.setCredit(db.rs.getString("credit"));
						eLecture.setProfessorName(db.rs.getString("professor"));
						eLecture.setTime(db.rs.getString("time"));
						items.add(eLecture);
					}
				}
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public Vector<ELecture> getDirectories(String type, String selectedName) throws FileNotFoundException {
		DBConnect  db = new DBConnect();
		Vector<ELecture> items = new Vector<ELecture>();
		int upperId = 0;
		if(type.equals("campus")) {
			try {
				db.select("select * from campus");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					ELecture eLecture= new ELecture();
					eLecture.setID(db.rs.getInt("ID"));
					eLecture.setName(db.rs.getString("name"));
					items.add(eLecture);
				}
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(type.equals("college")){
			try {
				db.select("select * from campus");
				while(db.rs.next()) {
					if(db.rs.getString("name").equals(selectedName)) {
						upperId = db.rs.getInt("ID");
						break;
					}
				}
				
				db.select("select * from college");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getInt("campus_ID") == upperId) {
						ELecture eLecture= new ELecture();
						eLecture.setID(db.rs.getInt("ID"));
						eLecture.setName(db.rs.getString("name"));
						eLecture.setUpperID(db.rs.getInt("campus_ID"));
						items.add(eLecture);
					}
					
				}
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(type.equals("department")) {
			try {
				db.select("select * from college");
				while(db.rs.next()) {
					if(db.rs.getString("name").equals(selectedName)) {
						upperId = db.rs.getInt("ID");
						break;
					}
				}
				
				db.select("select * from department");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getInt("college_ID") == upperId) {
						ELecture eLecture= new ELecture();
						eLecture.setID(db.rs.getInt("ID"));
						eLecture.setName(db.rs.getString("name"));
						eLecture.setUpperID(db.rs.getInt("college_ID"));
						items.add(eLecture);
					}
				}
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
