package Chapter2;

import java.util.Scanner;

public class M_CoffeePrice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� Ŀ�� �帱���??");
		System.out.print("=>"); String coffee = scanner.next();
		int price = 0;
		switch(coffee) {
			case "����������": case "īǪġ��": case "ī�����": price = 3500; break;
			case "�Ƹ޸�ī��": price = 2000; break;
			default: System.out.println("�޴��� ���� Ŀ���Դϴ�. ���ֹ��� �ֽʽÿ�.");
		}
		if(price != 0) System.out.println("�ֹ��Ͻ� " + coffee + "�� " + price + "�� �Դϴ�.");
		else System.out.println("�ֹ����� �����̽��ϴ�. �ֹ��� �ּ���");
		scanner.close();
	}
}
