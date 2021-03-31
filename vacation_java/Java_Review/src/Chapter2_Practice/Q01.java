package Chapter2_Practice;
/*
 * 프로그램명 : 환율 계산기
 * */
import java.util.Scanner;
public class Q01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 : 원)>>"); double won = scanner.nextDouble();
		double dollar = Exchange(won);
		System.out.println(won + "원은 $" + dollar + "입니다.");
	}
	public static double Exchange(double money) {
		double dollar;
		dollar = money / 1100;
		return dollar;
	}
}
