package Chapter4_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : MonthSchedule 작성
 * */
class Day {
	private String work;
	
	public void set(String work) {this.work=work;}
	public String get() {return work;}
	
	public void show() {
		if(work == null) System.out.println("없습니다.");
		else System.out.println(work + "입니다.");
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
		System.out.print("날짜(1~30)?>>");
		int day=scanner.nextInt();
		
		System.out.println("할일(빈칸 없이 입력)?");
		String work = scanner.next();
		day--;
		
		if(day<0 || day>n) {
			System.out.println("날짜를 잘못 입력하셨습니다!");
			return;
		}
		days[day].set(work);
	}
	
	public void view() {
		System.out.print("날짜(1~30)?>>");
		int day=scanner.nextInt();
		day--;
		if(day<0 || day>n) {
			System.out.println("날짜를 잘못 입력하셨습니다!");
			return;
		}
		System.out.print((day+1) + "일의 할 일은 ");
		days[day].show();
	}
	
	public void finish() {
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() {
		System.out.println("이번달 스케쥴 관리 프로그램.");
		
		while(true) {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default: System.out.println("잘못입력하셨습니다.");
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
