package Chapter2_Practice;
/*
 * ���α׷��� : ������ 3,6,9
 * */
import java.util.Scanner;
public class Q06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~99������ ������ �ϳ� �Է��ϼ���.>>"); int n = scanner.nextInt();
		int tens, ones;
		tens = n / 10;
		n = n % 10;
		
		if((tens == 3 || tens == 6 || tens == 9) && (n == 3 || n == 6 || n == 9)) System.out.println("�ڼ�¦¦");
		else if((tens == 3 || tens == 6 || tens == 9) || (n == 3 || n == 6 || n == 9)) System.out.println("�ڼ�¦");
		else System.out.println("����");
	}
}
