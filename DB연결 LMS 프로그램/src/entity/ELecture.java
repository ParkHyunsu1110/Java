package entity;

import java.io.Serializable;
import java.util.Scanner;

public class ELecture implements Serializable{

	private int ID;
	private int upperID;
	private String number;
	private String name;
	private String professorName;
	private String credit;
	private String time;
	
	
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getUpperID() {
		return upperID;
	}
	public void setUpperID(int upperID) {
		this.upperID = upperID;
	}
	
	public void readLecture(Scanner scanner) {
		this.number = scanner.next();
		this.name = scanner.next();
		this.professorName = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}
	
	public void readDirectory(Scanner scanner) {
		this.number = scanner.next();
		this.name = scanner.next();
	}
		
}
