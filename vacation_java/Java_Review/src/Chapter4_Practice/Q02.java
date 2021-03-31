package Chapter4_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : Grade 클래스 작성, 3과목 점수 입력 받아 성적 평균 출력
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
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("과목 평균은 " + me.average() + "입니다.");
	}

}
