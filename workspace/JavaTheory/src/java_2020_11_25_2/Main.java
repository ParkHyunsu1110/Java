package java_2020_11_25_2;

import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VStudent hong = new VStudent();
		VStudent seong = new VStudent();
		hong.setName("홍길동");
		seong.setName("성춘향");
		
		hong.setAge(20);
		seong.setAge(18);
		
		hong.setMajor("컴퓨터공학과");
		seong.setMajor(null);
		
		Vector<VStudent> vector = new Vector<VStudent>();
		
	}
}
