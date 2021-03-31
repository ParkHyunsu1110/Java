package entity;

import java.util.Scanner;

public class EMember {
	private String userId;
	private String password;
	private String name;
	private String campus;
	private String college;
	private String department;
	private String number;
	private String birth;
	private String phone;
	private String rLine;
	private boolean IDcheck = false;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
	public boolean getIDcheck() {
		return this.IDcheck;
	}
	public void setIDcheck(boolean IDcheck) {
		this.IDcheck = IDcheck;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public void read(Scanner scanner) {
		this.userId = scanner.next();
		this.password = scanner.next();
		this.name = scanner.next();
		this.campus = scanner.next();
		this.college = scanner.next();
		this.department = scanner.next();
		this.number = scanner.next();
		this.birth = scanner.next();
		this.phone = scanner.next();
	}
	
	public void read_Re(Scanner scanner) {
		this.setrLine(scanner.nextLine());
	}
	public String getrLine() {
		return rLine;
	}
	public void setrLine(String rLine) {
		this.rLine = rLine;
	}
}
