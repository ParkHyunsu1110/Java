package Chapter2;

import java.util.Scanner;

public class A_Sum {
	public static int Sum(int n, int m) {
		return n + m;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		System.out.println("숫자 2개를 입력해 주세요.");
		int i = scanner.nextInt();
		int s = scanner.nextInt();
		int sum = Sum(i,s);;
		/*int i = 10;
		int s = 20;
		int s = Sum(i,s;);*/
		System.out.println(sum);
		scanner.close();
	}
}
