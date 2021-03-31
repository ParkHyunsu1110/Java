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

	public boolean RepetiteID(String sid) // ���̵� �ߺ� Ȯ��
	{
		this.session.sendProtocol("StudentManager/RepetiteID/member/" + sid);
		
		VOMember voMember = this.session.getMemberObject();
		
		return voMember.getIDcheck();
	}

	public boolean PasswordMatchChk(String spw, String sRepw) {
		// ��й�ȣ �Է� �� �� ��й�ȣ�� ��Ȯ�� ��й�ȣ�� ��ġ�ϴ��� Ȯ��
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
