package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : 0���� ������ �߻��ϴ� ArithmeticException ���� ó��
 * */
public class N_DevideByZeroHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("�������� �Է��ϼ���.>>");
			int dividend = scanner.nextInt();
			System.out.print("�������� �Է��ϼ���>>");
			int divisor = scanner.nextInt();
			try {
				System.out.println(dividend + " �� " + divisor + "�� ������ ���� " + dividend/divisor +"�Դϴ�.");
				break;
			}catch(ArithmeticException e){
				System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է��ϼ���!!");
			}
		}
		scanner.close();
	}
}
