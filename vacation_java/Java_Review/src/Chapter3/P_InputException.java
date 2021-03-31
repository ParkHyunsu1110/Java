package Chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 프로그램명 : 3개의정수를 입력받아 합을 구하는 프로그램, 사용자가 정수가 아닌 문자를 입력할때 발생하는 InputMismatchException 예외 처리해서 다시 입력 받기.
 * */
public class P_InputException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요.");
		int sum = 0, n = 0;
		for(int i = 0; i < 3; i++) {
			System.out.println(i + ">>");
			try {
				n = scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력하세요.");
				scanner.nextLine();
				i--;
				continue;
			}
			sum += n;
		}
		System.out.println("합은 " + sum);
		scanner.close();
	}
}
