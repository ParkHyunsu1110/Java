package Chapter4_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : MonthSchedule �ۼ�
 * */
class Day {
	private String work;
	
	public void set(String work) {this.work=work;}
	public String get() {return work;}
	
	public void show() {
		if(work == null) System.out.println("�����ϴ�.");
		else System.out.println(work + "�Դϴ�.");
	}
}
public class Q07 {
	private int n;
	private Scanner scanner;
	private Day[] days;
	
	public Q07(int n) {
		this.n=n;
		this.days=new Day[n];
		for(int i=0; i<days.length; i++) {
			days[i] = new Day();
		}
		scanner = new Scanner(System.in);
	}
	
	public void input() {
		System.out.print("��¥(1~30)?>>");
		int day=scanner.nextInt();
		
		System.out.println("����(��ĭ ���� �Է�)?");
		String work = scanner.next();
		day--;
		
		if(day<0 || day>n) {
			System.out.println("��¥�� �߸� �Է��ϼ̽��ϴ�!");
			return;
		}
		days[day].set(work);
	}
	
	public void view() {
		System.out.print("��¥(1~30)?>>");
		int day=scanner.nextInt();
		day--;
		if(day<0 || day>n) {
			System.out.println("��¥�� �߸� �Է��ϼ̽��ϴ�!");
			return;
		}
		System.out.print((day+1) + "���� �� ���� ");
		days[day].show();
	}
	
	public void finish() {
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	public void run() {
		System.out.println("�̹��� ������ ���� ���α׷�.");
		
		while(true) {
			System.out.print("����(�Է�:1, ����:2, ������:3) >>");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default: System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q07 april = new Q07(30);
		april.run();
		
	}

}
