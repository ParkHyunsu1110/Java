package global;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import client.Session;
import valueobject.VOMember;

public class MemberCheck {
	
	private Session session;
	
	public MemberCheck(Session session) {
		this.session = session;
	}

	public boolean RepetiteID(String sid) // 아이디 중복 확인
	{
		this.session.sendProtocol("StudentManager/RepetiteID/member/" + sid);
		
		VOMember voMember = this.session.getMemberObject();
		
		return voMember.getIDcheck();
	}

	public boolean PasswordMatchChk(String spw, String sRepw) {
		// 비밀번호 입력 후 그 비밀번호와 재확인 비밀번호가 일치하는지 확인
		if (spw.equals(sRepw))
			return true;
		else
			return false;
	}

	public String find_id(String Name, String Depart, String Num) {
		this.session.sendProtocol("StudentManager/FindID_PW/member/" + Name + "," + Depart + "," + Num);
		
		VOMember voMember = this.session.getMemberObject();
		
		return voMember.getUserId();
	}

	public String find_pw(String Id, String Name, String Depart, String Num, String Phone) {
		this.session.sendProtocol("StudentManager/FindID_PW/member/" + Id + "," + Name+ "," + Depart + "," + Num + "," + Phone);
		
		VOMember voMember = this.session.getMemberObject();
		
		return voMember.getPassword();
	}
}
