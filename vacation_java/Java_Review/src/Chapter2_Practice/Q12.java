package Chapter2_Practice;
/*
 * 프로그램명 : 사칙연산
 */
import java.util.Scanner;
public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("If_Else 문으로 알아보려면 i, Switch문으로 알아보려면 s를 입력해 주세요.>>"); String choose = scanner.next();
		
		int result = 0;
		if(choose.equals("i")) {
			System.out.print("연산>>"); int n = scanner.nextInt(); String ls = scanner.next(); int m = scanner.nextInt();
			if(ls.equals("+")) System.out.println(n + ls + m + " = " + (n+m));
			else if(ls.equals("-")) System.out.println(n + ls + m + " = " + (n-m));
			else if(ls.equals("*")) System.out.println(n + ls + m + " = " + (n*m));
			else if(ls.equals("/")) {
				if(m == 0)
					System.out.println("0으로 나눌 수 없습니다.");
				System.out.println(n + ls + m + " = " + (n/m));
			}else System.out.println("계산할 수 없는 기호입니다.");
		}else if(choose.equals("s")) {
			System.out.print("연산>>"); int n = scanner.nextInt(); String ls = scanner.next(); int m = scanner.nextInt();
			switch(ls) {
				case "+": System.out.println(n + ls + m + " = " + (n+m)); break;
				case "-": System.out.println(n + ls + m + " = " + (n-m)); break;
				case "*": System.out.println(n + ls + m + " = " + (n*m)); break;
				case "/": System.out.println(n + ls + m + " = " + (n/m)); break;
				default: break;
			}
		}else System.out.println("계산을 못합니다...");
	}
}
