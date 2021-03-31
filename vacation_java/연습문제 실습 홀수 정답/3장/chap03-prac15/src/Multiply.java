import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiply {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("���ϰ��� �ϴ� �� �� �Է�>>");
			try {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				System.out.print(n + "x" + m + "=" + n*m);
				break;
			} catch(InputMismatchException e) {
				System.out.println("�Ǽ��� �Է��ϸ� �ȵ˴ϴ�.");
				scanner.nextLine(); // <Enter> Ű���� �о ������.
				continue;
			}
		} while(true);

		scanner.close();
	}
}
