package Chapter3;

import java.util.Scanner;

/*
 * 프로그램명 : "exit"입력하면 while 문을 벗어나는 코드 작성하기.
 * */
public class F_BreakWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("exit를 입력하면 종료합니다.");
		while(true) {
			System.out.print(">>");
			String text = scanner.next();
			if(text.equals("exit")) break;
		}
		System.out.println("종료합니다....");
		scanner.close();
	}
}
