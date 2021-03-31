package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import entity.ELecture;
import global.DBConnect;

public class DAOBasket {

	public Vector<ELecture> add(String[] basket_infor) throws IOException{
		String type = basket_infor[0];
		String userId = basket_infor[1];
		String lecture_ID = basket_infor[2];
		Vector<ELecture> items = new Vector<ELecture>();
		DBConnect db = new DBConnect();

		String st = "INSERT INTO " + type + " (member_ID, lecture_ID)" + 
				" VALUES('"+userId + "','" + lecture_ID + "')";
		db.update(st);
		db.close();
		
		return items;
	}

	public Vector<ELecture> show(String[] basket_infor) throws IOException {
		String type = basket_infor[0];
		String userId = basket_infor[1];
		int cnt = 0;
		int roll = 0;
		String[] lecture;

		Vector<ELecture> items = new Vector<ELecture>();
		DBConnect db = new DBConnect();

		try {
			db.select("select * from " + type);
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(userId)) {
					cnt++;
				}
			}
			lecture = new String[cnt];
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(userId)) {
					lecture[roll] = db.rs.getString("lecture_ID");
					roll++;
				}
			}
			
			db = new DBConnect();
			db.select("select * from lecture");
			db.rs.beforeFirst();
			for(int i = 0; i < lecture.length; i++) {
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getString("ID").equals(lecture[i])) {
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
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	public Vector<ELecture> remove(String[] basket_infor) throws IOException{
		String type = basket_infor[0];
		String userId = basket_infor[1];
		String lecture_ID = basket_infor[2];
		Vector<ELecture> items = new Vector<ELecture>();
		DBConnect db = new DBConnect();

		try {
			db.update("delete from " + type + " where member_ID = '" + userId + "' and lecture_ID = '" + lecture_ID + "'");

			db.select("select * from " + type);
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(userId)) {
					String lecture = db.rs.getString("lecture_ID");

					db.select("select * from lecture");
					db.rs.beforeFirst();
					while(db.rs.next()) {
						if(db.rs.getString("ID").equals(lecture)) {
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
				}
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
}
