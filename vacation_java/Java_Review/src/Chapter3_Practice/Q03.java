package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : Scanner를 사용한 *로 이뤄진 역삼각형 만들기
 * */
public class Q03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요.>>"); int h = scanner.nextInt();
		for(int i = h; i > 0; i--) {
			for(int j = i; j>0; j--) 
				System.out.print("*");
			System.out.println();
		}
	}

}
