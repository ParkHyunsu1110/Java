package Chapter3;

import java.util.Scanner;

/*
 * 프로그램명 : 0으로 나눌때 발생하는 ArithmeticException 예외 처리
 * */
public class N_DevideByZeroHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("나눔수를 입력하세요.>>");
			int dividend = scanner.nextInt();
			System.out.print("나눗수를 입력하세요>>");
			int divisor = scanner.nextInt();
			try {
				System.out.println(dividend + " 를 " + divisor + "로 나누면 몫은 " + dividend/divisor +"입니다.");
				break;
			}catch(ArithmeticException e){
				System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요!!");
			}
		}
		scanner.close();
	}
}
