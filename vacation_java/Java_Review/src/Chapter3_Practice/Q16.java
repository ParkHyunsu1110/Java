package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 가위바위보 하기
 * */
public class Q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String str[] = {"가위","바위","보"};
		System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
		
		while(true) {
			int c_rsp_n = 0;
			String c_rsp;
			
			System.out.print("가위 바위 보! >>"); String rsp = scanner.next();
			if(rsp.equals("그만")) { 
				System.out.println("게임을 종료합니다....");
				break;
			}else {
				c_rsp_n = (int)(Math.random()*3);
				c_rsp =str[c_rsp_n];
				
				if(c_rsp.equals("가위") == true) {
					if(rsp.equals("가위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 비겼습니다.");
					else if(rsp.equals("바위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 이겼습니다.");
					else if(rsp.equals("보") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 졌습니다.");
				}else if(c_rsp.equals("바위") == true) {
					if(rsp.equals("가위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 졌습니다.");
					else if(rsp.equals("바위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 비겼습니다.");
					else if(rsp.equals("보") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 이겼습니다.");
				} else if(c_rsp.equals("보") == true)  {
					if(rsp.equals("가위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 이겼습니다.");
					else if(rsp.equals("바위") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 졌습니다.");
					else if(rsp.equals("보") == true) System.out.println("사용자 : " + rsp + ", 컴퓨터 : " + c_rsp + ", 비습니다.");
				}
				
			}
		}
		scanner.close();
	}
}
