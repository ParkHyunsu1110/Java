package Chapter4_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ��ȭ��ȣ�� ����
 * */
class Phone {
	String name;
	String tel;
	Phone(String name, String tel) { this.name=name; this.tel=tel; }
	public void show() {
		System.out.println(name + " �� ��ȣ�� " + tel + "�Դϴ�.");
	}
}
public class Q08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ο���>>");
		int n=scanner.nextInt();
		Phone[] phone = new Phone[n];
		
		for(int i=0; i<n; i++) {
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� �� ĭ ���� �Է�)>>");
			String name=scanner.next();
			String tel=scanner.next();
			phone[i] = new Phone(name, tel);
		}
		System.out.println("����Ǿ����ϴ�...");
		while(true) {
			int sum = 0;
			System.out.print("�˻��� �̸�>>");
			String name = scanner.next();
			if(name.equals("�׸�")) break;
			for(int i=0; i<n; i++) {
				if(name.equals(phone[i].name)) phone[i].show();
				else {
					sum++;
					if(sum == n) System.out.println(name + "�� �����ϴ�.");
				}
			}
			
			
		}
	}
}
