import java.util.Scanner;

public class Won2Dollar {

	public static void main(String[] args) {
		final double rate = 1100.0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ȭ�� �Է��ϼ���(���� ��)>>");
		int won = scanner.nextInt();
		double dollar = won/rate;
		System.out.printf(won + "���� $" + dollar + "�Դϴ�.");
		scanner.close();
	}

}
