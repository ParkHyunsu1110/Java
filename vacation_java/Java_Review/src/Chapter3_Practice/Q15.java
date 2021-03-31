package Chapter3_Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 프로그램명 : 2개의 정수를 입력받아 곱을 구하라.
 * 			 만일 실수가 입력되면 정수를 다시 입력하도록 한다.
 * */
public class Q15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("곱하고자 하는 두 수 입력.>>");
			try {
				int a = scanner.nextInt(); int b = scanner.nextInt();
				System.out.print(a + " X " + b + " = " + a*b);
				break;
			}catch(InputMismatchException e) {
				System.out.println("실수는 입력하면 안됩니다.");
				scanner.nextLine();
			}
		}
	}

}
