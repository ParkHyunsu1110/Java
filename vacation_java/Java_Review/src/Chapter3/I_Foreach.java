package Chapter3;

import java.util.Scanner;

/*
 * 프로그래명 : for-each 문을 활용해라.
 * */
public class I_Foreach {
	enum Week{월, 화, 수, 목, 금, 토, 일};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] n = {1,2,3,4,5};
		int sum = 0;
		for(int k:n) {
			System.out.print(k + " ");
			sum += k;
		}
		System.out.println("합은 " + sum + "입니다.");
		
		String name[] = {"사과","배","바나나","체리","딸기","포도"};
		for(String fruits:name)
			System.out.print(fruits + " ");
		System.out.println();
		
		for(Week day: Week.values()) 
			System.out.print(day + "요일 ");
		System.out.println();
	}

}
