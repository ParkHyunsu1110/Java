package Chapter2;

import java.util.Scanner;

/*
 * ���α׷��� : ���������� ����
 * */
public class Open_Challenge_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� �����Դϴ�. ����,����,�� �߿��� �Է��ϼ���.");
		System.out.print("ö��>>"); String c = scanner.nextLine();
		System.out.print("����>>"); String y = scanner.nextLine();
		if(c.equals("����") == true) {
			if(y.equals("����") == true) System.out.println("�����ϴ�!!");
			else if(y.equals("����") == true) System.out.println("���� �̰���ϴ�!!");
			else if(y.equals("��") == true) System.out.println("ö���� �̰���ϴ�!!");
			else System.out.println("���� �߸��½��ϴ�... �ٽ� ������ �ּ���!!");
		}
		
		else if(c.equals("����") == true) {
			if(y.equals("����") == true) System.out.println("ö���� �̰���ϴ�!!");
			else if(y.equals("����") == true) System.out.println("�����ϴ�!!");
			else if(y.equals("��") == true) System.out.println("���� �̰���ϴ�!!");
			else System.out.println("���� �߸��½��ϴ�... �ٽ� ������ �ּ���!!");
		}
		
		else if(c.equals("��") == true) {
			if(y.equals("����") == true) System.out.println("���� �̰���ϴ�!!");
			else if(y.equals("����") == true) System.out.println("ö���� �̰���ϴ�!!");
			else if(y.equals("��") == true) System.out.println("�����ϴ�!!");
			else System.out.println("���� �߸��½��ϴ�... �ٽ� ������ �ּ���!!");
		}
		
		else System.out.println("ö���� �߸��½��ϴ�... �ٽ� ������ �ּ���!!");
	}

}
