package service;

import java.io.FileNotFoundException;
import java.util.Vector;

import dao.DAOMember;
import dao.ELogin;
import entity.EMember;
import server.Session;
import valueobject.VOMember;

public class StudentManager extends Session{
	
	private DAOMember daoMember;
	private ELogin eLogin;
	
	public StudentManager() {
		this.daoMember = new DAOMember();
		this.eLogin = new ELogin();
	}
	public VOMember writeMember(String fileName, String user) {
		String[] user_infor = user.split(",");
		String filename = "information/" + fileName;
		this.daoMember.rewrite(filename, user_infor);
		VOMember voMember = new VOMember();
		return voMember;
	}
	
	public Vector<VOMember> getMembers(String fileName, String user) {
		Vector<EMember> items = this.daoMember.getItems();
		Vector<VOMember> voMember = new Vector<VOMember>();
		
		for(int i = 0; i<items.size(); i++) {
			VOMember vo = new VOMember();
			vo.setUserId(items.get(i).getUserId());
			vo.setPassword(items.get(i).getPassword());
			vo.setName(items.get(i).getName());
			vo.setCampus(items.get(i).getCampus());
			vo.setCollege(items.get(i).getCampus());
			vo.setDepartment(items.get(i).getDepartment());
			vo.setNumber(items.get(i).getNumber());
			vo.setBirth(items.get(i).getBirth());
			vo.setPhone(items.get(i).getPhone());
			
			voMember.add(vo);
		}
		return voMember;
	}
	
	public VOMember getInfor(String fileName, String user){
		return this.eLogin.getInfor(user);
	}
	
	public VOMember getMember(String fileName, String user) throws FileNotFoundException{		
		String[] user_information = user.split(",");
		return this.eLogin.authenticate(user_information[0], user_information[1]);
	}
	
	public VOMember RepetiteID(String fileName, String user) {
		return this.eLogin.RepetiteId(user);
	}
	
	public VOMember newMember(String fileName, String user) {
		String[] infor = user.split(",");
		this.eLogin.newMember(infor);
		VOMember vo = new VOMember();
		return vo;
	}
	
	public VOMember FindID_PW(String fileName, String user) {
		return this.eLogin.find(user);
	}
}
