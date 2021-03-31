package Chapter3;

import java.util.Scanner;

/*
 * 프로그램명 : -1이 입력될 때 까지의 평균(While)
 * */
public class B_WhileAverage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		System.out.println("정수를 입력하고, 마지막에 -1을 입력하세요.");
		int n = scanner.nextInt();
		
		while(n != -1) {
			sum += n;
			count++;
			n = scanner.nextInt();
		}
		if(count == 0) System.out.println("입력된 정수가 없습니다.");
		else {
			System.out.print("입력된 정수의 갯수는 " + count + "개 이고,");
			System.out.println("평균은 " + (double)sum/count + "입니다.");
		}
	}

}
