package Chapter3;

import java.util.Scanner;

/*
 * 프로그램명 : 입력받은 5개의 정수 중 양수만 합하라
 * */
public class E_CountinueSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 5개 입력하세요.");
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			if(n <= 0)
				continue;
			else sum += n;
		}
		System.out.println("양수의 합은 " + sum + "입니다.");
		
		scanner.close();
	}
}
