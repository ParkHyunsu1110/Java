package Chapter2;

import java.util.Scanner;

public class L_NestedIf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.(0~100)");
		System.out.print("=>"); int score = scanner.nextInt();
		System.out.println("�г��� �Է��ϼ���.");
		System.out.print("=>"); int year = scanner.nextInt();
		if(score>=60) {
			if(year != 4) System.out.println("���ϵ帳�ϴ�. �հ��Դϴ�.");
			else if(score >= 70) System.out.println("���ϵ帳�ϴ�. �հ��Դϴ�.");
			else System.out.println("���հ��Դϴ�.");
		}else System.out.println("���հ��Դϴ�.");
		scanner.close();
	}

}
