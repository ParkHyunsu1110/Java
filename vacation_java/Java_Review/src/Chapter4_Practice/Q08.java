package Chapter4_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 전화번호부 생성
 * */
class Phone {
	String name;
	String tel;
	Phone(String name, String tel) { this.name=name; this.tel=tel; }
	public void show() {
		System.out.println(name + " 의 번호는 " + tel + "입니다.");
	}
}
public class Q08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("인원수>>");
		int n=scanner.nextInt();
		Phone[] phone = new Phone[n];
		
		for(int i=0; i<n; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
			String name=scanner.next();
			String tel=scanner.next();
			phone[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다...");
		while(true) {
			int sum = 0;
			System.out.print("검색할 이름>>");
			String name = scanner.next();
			if(name.equals("그만")) break;
			for(int i=0; i<n; i++) {
				if(name.equals(phone[i].name)) phone[i].show();
				else {
					sum++;
					if(sum == n) System.out.println(name + "이 없습니다.");
				}
			}
			
			
		}
	}
}
