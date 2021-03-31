package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 돈의 액수 입력 받아 각각 지폐 몇 개로 변환되는지 출력하라.
 * */
public class Q06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		int tmp = 0;
		System.out.print("금액을 입력하시오.>>"); int n = scanner.nextInt();
		for(int i = 0; i< unit.length; i++) {
			if(n/unit[i] != 0) 
				System.out.println(unit[i] + " 원 짜리 : " + n/unit[i] + "개");
			n %= unit[i];
		}
		scanner.close();
	}
}
