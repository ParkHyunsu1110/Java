package Chapter2_Practice;
/*
 * 프로그램명 : 간단한 3,6,9
 * */
import java.util.Scanner;
public class Q06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~99사이의 정수를 하나 입력하세요.>>"); int n = scanner.nextInt();
		int tens, ones;
		tens = n / 10;
		n = n % 10;
		
		if((tens == 3 || tens == 6 || tens == 9) && (n == 3 || n == 6 || n == 9)) System.out.println("박수짝짝");
		else if((tens == 3 || tens == 6 || tens == 9) || (n == 3 || n == 6 || n == 9)) System.out.println("박수짝");
		else System.out.println("실패");
	}
}
