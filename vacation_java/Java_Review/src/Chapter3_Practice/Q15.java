package Chapter3_Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * ���α׷��� : 2���� ������ �Է¹޾� ���� ���϶�.
 * 			 ���� �Ǽ��� �ԷµǸ� ������ �ٽ� �Է��ϵ��� �Ѵ�.
 * */
public class Q15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("���ϰ��� �ϴ� �� �� �Է�.>>");
			try {
				int a = scanner.nextInt(); int b = scanner.nextInt();
				System.out.print(a + " X " + b + " = " + a*b);
				break;
			}catch(InputMismatchException e) {
				System.out.println("�Ǽ��� �Է��ϸ� �ȵ˴ϴ�.");
				scanner.nextLine();
			}
		}
	}

}
