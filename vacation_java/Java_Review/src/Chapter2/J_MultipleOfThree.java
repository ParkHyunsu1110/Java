package Chapter2;

import java.util.Scanner;

public class J_MultipleOfThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ���� ������ �Է��� �ּ���.");
		int i = scanner.nextInt();
		if((i % 3 == 1) || (i % 3 == 2)) System.out.println(i + "�� 3�� ����� �ƴմϴ�");
		else System.out.println(i + "�� 3�� ����Դϴ�.");
		scanner.close();
	}
}
