package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : Scanner를 이용하여 알파벳을 입력받고 역삼각형 만들기
 * */
public class Q04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("소문자 알파벳 하나를 입력하세요.>>");
		String al = scanner.next();
		char c = al.charAt(0);
		for(int i = c-'a'; i >=0; i--) {
			for(int j = 0; j<=i; j++)
				System.out.print((char)('a'+j));
			System.out.println();
		}
	}
}
