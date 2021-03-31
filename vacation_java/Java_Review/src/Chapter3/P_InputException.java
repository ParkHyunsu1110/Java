package Chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * ���α׷��� : 3���������� �Է¹޾� ���� ���ϴ� ���α׷�, ����ڰ� ������ �ƴ� ���ڸ� �Է��Ҷ� �߻��ϴ� InputMismatchException ���� ó���ؼ� �ٽ� �Է� �ޱ�.
 * */
public class P_InputException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� 3���� �Է��ϼ���.");
		int sum = 0, n = 0;
		for(int i = 0; i < 3; i++) {
			System.out.println(i + ">>");
			try {
				n = scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���.");
				scanner.nextLine();
				i--;
				continue;
			}
			sum += n;
		}
		System.out.println("���� " + sum);
		scanner.close();
	}
}
