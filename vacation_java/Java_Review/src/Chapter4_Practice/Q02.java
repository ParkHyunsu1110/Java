package Chapter4_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : Grade Ŭ���� �ۼ�, 3���� ���� �Է� �޾� ���� ��� ���
 * */
class Grade{
	private int math;
	private int science;
	private int english;
	public Grade(int math, int science, int english) {
		this.math=math;
		this.science=science;
		this.english=english;
	}
	public double average() {
		return (math+science+english)/3;
	}
}
public class Q02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("����, ����, ���� ������ 3���� ���� �Է�");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("���� ����� " + me.average() + "�Դϴ�.");
	}

}
