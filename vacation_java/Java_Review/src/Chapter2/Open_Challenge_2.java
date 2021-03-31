package Chapter2;

import java.util.Scanner;

/*
 * 프로그램명 : 가위바위보 게임
 * */
public class Open_Challenge_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위,바위,보 중에서 입력하세요.");
		System.out.print("철수>>"); String c = scanner.nextLine();
		System.out.print("영희>>"); String y = scanner.nextLine();
		if(c.equals("가위") == true) {
			if(y.equals("가위") == true) System.out.println("비겼습니다!!");
			else if(y.equals("바위") == true) System.out.println("영희가 이겼습니다!!");
			else if(y.equals("보") == true) System.out.println("철수가 이겼습니다!!");
			else System.out.println("영희가 잘못냈습니다... 다시 실행해 주세요!!");
		}
		
		else if(c.equals("바위") == true) {
			if(y.equals("가위") == true) System.out.println("철수가 이겼습니다!!");
			else if(y.equals("바위") == true) System.out.println("비겼습니다!!");
			else if(y.equals("보") == true) System.out.println("영희가 이겼습니다!!");
			else System.out.println("영희가 잘못냈습니다... 다시 실행해 주세요!!");
		}
		
		else if(c.equals("보") == true) {
			if(y.equals("가위") == true) System.out.println("영희가 이겼습니다!!");
			else if(y.equals("바위") == true) System.out.println("철수가 이겼습니다!!");
			else if(y.equals("보") == true) System.out.println("비겼습니다!!");
			else System.out.println("영희가 잘못냈습니다... 다시 실행해 주세요!!");
		}
		
		else System.out.println("철수가 잘못냈습니다... 다시 실행해 주세요!!");
	}

}
