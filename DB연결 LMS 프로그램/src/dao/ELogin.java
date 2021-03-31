package dao;
import java.sql.SQLException;

import global.DBConnect;
import valueobject.VOMember;

public class ELogin {
	private VOMember voMember;

	public ELogin() {
		this.voMember = new VOMember();
	}
	
	public VOMember authenticate(String userId, String password) {
		DBConnect db = new DBConnect();
		db.select("select * from members");
		try {
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(userId) && db.rs.getString("password").equals(password)) {
					this.voMember.setUserId(db.rs.getString("member_ID"));
					this.voMember.setPassword(db.rs.getString("password"));
					this.voMember.setName(db.rs.getString("name"));
					this.voMember.setCampus(db.rs.getString("campus_ID"));
					this.voMember.setCollege(db.rs.getString("college_ID"));
					this.voMember.setDepartment(db.rs.getString("department_ID"));
					this.voMember.setNumber(db.rs.getString("number"));
					this.voMember.setBirth(db.rs.getString("birthday"));
					this.voMember.setPhone(db.rs.getString("phone"));
					this.voMember.setIDcheck(true);
				}
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return this.voMember;
	}

	public void newMember(String[] infor) {		
		DBConnect db = new DBConnect();
		try {
			db.select("select * from campus");
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("name").equals(infor[3])) {
					infor[3] = db.rs.getString("ID");
				}
			}
			
			db.select("select * from college");
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("name").equals(infor[4])) {
					infor[4] = db.rs.getString("ID");
				}
			}
			
			db.select("select * from department");
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("name").equals(infor[5])) {
					infor[5] = db.rs.getString("ID");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		String st = "INSERT INTO members(member_ID, password, name, campus_ID, college_ID, department_ID, number, birthday, phone) " + 
		"VALUES('"+infor[0] + "','" + infor[1] + "','" + infor[2] + "'," + infor[3] + "," +
				infor[4] + "," + infor[5] + ",'" + infor[6] + "','" + infor[7] + "','" + infor[8] + "')";
		db.update(st);
		
		db.close();
	}

	public VOMember RepetiteId(String user) {
		DBConnect db = new DBConnect();
		try {
			db.select("select member_ID from members");
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(user)) {
					this.voMember.setIDcheck(true);
				}
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return this.voMember;
	}

	public VOMember getInfor(String user) {
		DBConnect db = new DBConnect();
		db.select("select * from members");

		try {
			db.rs.beforeFirst();
			while(db.rs.next()) {
				if(db.rs.getString("member_ID").equals(user)) {
					this.voMember.setUserId(db.rs.getString("member_ID"));
					this.voMember.setPassword(db.rs.getString("password"));
					this.voMember.setName(db.rs.getString("name"));
					this.voMember.setCampus(db.rs.getString("campus_ID"));
					this.voMember.setCollege(db.rs.getString("college_ID"));
					this.voMember.setDepartment(db.rs.getString("department_ID"));
					this.voMember.setNumber(db.rs.getString("number"));
					this.voMember.setBirth(db.rs.getString("birthday"));
					this.voMember.setPhone(db.rs.getString("phone"));
				}
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return this.voMember;
	}

	public VOMember find(String user) {
		DBConnect db = new DBConnect();
		String[] infor = user.split(",");
		try {
			if(infor.length>3) {
				db.select("select * from department");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getString("name").equals(infor[2])) {
						infor[2] = db.rs.getString("ID");
					}
				}
				db.select("select * from members");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getString("member_ID").equals(infor[0]) && db.rs.getString("name").equals(infor[1]) && db.rs.getString("department_ID").equals(infor[2]) && 
							db.rs.getString("number").equals(infor[3]) && db.rs.getString("phone").equals(infor[4])) {
						this.voMember.setUserId(db.rs.getString("member_ID"));
						this.voMember.setPassword(db.rs.getString("password"));
						this.voMember.setName(db.rs.getString("name"));
						this.voMember.setCampus(db.rs.getString("campus_ID"));
						this.voMember.setCollege(db.rs.getString("college_ID"));
						this.voMember.setDepartment(db.rs.getString("department_ID"));
						this.voMember.setNumber(db.rs.getString("number"));
						this.voMember.setBirth(db.rs.getString("birthday"));
						this.voMember.setPhone(db.rs.getString("phone"));
					}
				}
				db.close();
			}else {
				db.select("select * from department");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getString("name").equals(infor[1])) {
						infor[1] = db.rs.getString("ID");
					}
				}
				db.select("select * from members");
				db.rs.beforeFirst();
				while(db.rs.next()) {
					if(db.rs.getString("member_ID")==infor[0] && db.rs.getString("department_ID")==infor[1] && db.rs.getString("name")==infor[2] ) {
						this.voMember.setUserId(db.rs.getString("member_ID"));
						this.voMember.setPassword(db.rs.getString("password"));
						this.voMember.setName(db.rs.getString("name"));
						this.voMember.setCampus(db.rs.getString("campus_ID"));
						this.voMember.setCollege(db.rs.getString("college_ID"));
						this.voMember.setDepartment(db.rs.getString("department_ID"));
						this.voMember.setNumber(db.rs.getString("number"));
						this.voMember.setBirth(db.rs.getString("birthday"));
						this.voMember.setPhone(db.rs.getString("phone"));
					}
				}
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voMember;
	}
}