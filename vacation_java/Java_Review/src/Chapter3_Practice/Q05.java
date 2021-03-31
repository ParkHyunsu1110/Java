package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 양의 정수 10개 입력 받아 배열에 저장하고, 배열에 있는 정수중에서 3의 배수만 출력하라
 * */
public class Q05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] n = new int [10];
		System.out.print("양의 정수 10개 입력하시오.>>"); 
		for(int i = 0; i<n.length; i++) 
			n[i] = scanner.nextInt();
		System.out.print("3의 배수>>");
		for(int j = 0; j<n.length; j++)
			if(n[j]%3 == 0)
				System.out.print(n[j] + " ");
		System.out.println();
	}
}
