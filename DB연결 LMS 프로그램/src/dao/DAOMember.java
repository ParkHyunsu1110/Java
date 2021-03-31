package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import entity.EMember;
import global.DBConnect;

public class DAOMember {
	private File file = new File("information/member");
	private EMember eMember;

	public DAOMember() {
		this.eMember = new EMember();
	}

	public Vector<EMember> getItems() {
		Vector<EMember> items = new Vector<EMember>();
		DBConnect db = new DBConnect();
		db.select("select * from members");

		try {
			db.rs.beforeFirst();
			while(db.rs.next()) {
				this.eMember.setUserId(db.rs.getString("member_ID"));
				this.eMember.setPassword(db.rs.getString("password"));
				this.eMember.setName(db.rs.getString("name"));
				this.eMember.setCampus(db.rs.getString("campus_ID"));
				this.eMember.setCollege(db.rs.getString("college_ID"));
				this.eMember.setDepartment(db.rs.getString("department_ID"));
				this.eMember.setNumber(db.rs.getString("number"));
				this.eMember.setBirth(db.rs.getString("birthday"));
				this.eMember.setPhone(db.rs.getString("phone"));

				items.add(this.eMember);
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	public void rewrite(String fileName, String[] user_infor) {
		DBConnect db = new DBConnect();
		
		db.update("update members set password='" + user_infor[1] + "',birthday=" + user_infor[7] + ",phone='" + user_infor[8]
				+ "' where member_ID='" + user_infor[0] + "'");
	}
}