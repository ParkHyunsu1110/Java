package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : -1�� �Էµ� �� ������ ���(While)
 * */
public class B_WhileAverage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		System.out.println("������ �Է��ϰ�, �������� -1�� �Է��ϼ���.");
		int n = scanner.nextInt();
		
		while(n != -1) {
			sum += n;
			count++;
			n = scanner.nextInt();
		}
		if(count == 0) System.out.println("�Էµ� ������ �����ϴ�.");
		else {
			System.out.print("�Էµ� ������ ������ " + count + "�� �̰�,");
			System.out.println("����� " + (double)sum/count + "�Դϴ�.");
		}
	}

}
