package Chapter2_Practice;
/*
 * ���α׷��� : ��Ģ����
 */
import java.util.Scanner;
public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("If_Else ������ �˾ƺ����� i, Switch������ �˾ƺ����� s�� �Է��� �ּ���.>>"); String choose = scanner.next();
		
		int result = 0;
		if(choose.equals("i")) {
			System.out.print("����>>"); int n = scanner.nextInt(); String ls = scanner.next(); int m = scanner.nextInt();
			if(ls.equals("+")) System.out.println(n + ls + m + " = " + (n+m));
			else if(ls.equals("-")) System.out.println(n + ls + m + " = " + (n-m));
			else if(ls.equals("*")) System.out.println(n + ls + m + " = " + (n*m));
			else if(ls.equals("/")) {
				if(m == 0)
					System.out.println("0���� ���� �� �����ϴ�.");
				System.out.println(n + ls + m + " = " + (n/m));
			}else System.out.println("����� �� ���� ��ȣ�Դϴ�.");
		}else if(choose.equals("s")) {
			System.out.print("����>>"); int n = scanner.nextInt(); String ls = scanner.next(); int m = scanner.nextInt();
			switch(ls) {
				case "+": System.out.println(n + ls + m + " = " + (n+m)); break;
				case "-": System.out.println(n + ls + m + " = " + (n-m)); break;
				case "*": System.out.println(n + ls + m + " = " + (n*m)); break;
				case "/": System.out.println(n + ls + m + " = " + (n/m)); break;
				default: break;
			}
		}else System.out.println("����� ���մϴ�...");
	}
}
