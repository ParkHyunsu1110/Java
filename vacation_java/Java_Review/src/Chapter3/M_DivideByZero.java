package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : 0���� ������ ���� �߻����� ���α׷��� ���� ����Ǵ� ���
 * */
public class M_DivideByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int dividend;
		int divisor;
		
		System.out.print("�������� �Է��Ͻÿ�.>>");
		dividend = scanner.nextInt();
		System.out.print("�������� �Է��Ͻÿ�.>>");
		divisor = scanner.nextInt();
		System.out.println(dividend + " �� " + divisor + "�� ������ ���� " + dividend/divisor + "�Դϴ�.");
		scanner.close();
	}

}
