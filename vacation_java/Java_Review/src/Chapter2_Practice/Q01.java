package Chapter2_Practice;
/*
 * ���α׷��� : ȯ�� ����
 * */
import java.util.Scanner;
public class Q01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ȭ�� �Է��ϼ���(���� : ��)>>"); double won = scanner.nextDouble();
		double dollar = Exchange(won);
		System.out.println(won + "���� $" + dollar + "�Դϴ�.");
	}
	public static double Exchange(double money) {
		double dollar;
		dollar = money / 1100;
		return dollar;
	}
}
