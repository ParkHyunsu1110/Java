package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : "exit"�Է��ϸ� while ���� ����� �ڵ� �ۼ��ϱ�.
 * */
public class F_BreakWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("exit�� �Է��ϸ� �����մϴ�.");
		while(true) {
			System.out.print(">>");
			String text = scanner.next();
			if(text.equals("exit")) break;
		}
		System.out.println("�����մϴ�....");
		scanner.close();
	}
}
