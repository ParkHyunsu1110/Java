package Chapter2;

import java.util.Scanner;

public class I_SuccessOrFail {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� �Է��� �ּ���.");
		System.out.print("=>");
		double score = scanner.nextDouble();
		if(score >= 80) System.out.println("�����մϴ�!" + score + "������ �հ��Դϴ�!!");
		else System.out.println("�ƽ��׿� ���� �� ����غ���!!");
		scanner.close();
	}
}
