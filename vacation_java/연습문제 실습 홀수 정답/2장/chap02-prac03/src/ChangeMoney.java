import java.util.Scanner;

public class ChangeMoney {
	// ȯ���� ���� ���� ��� ����. �ѱ� ���� ����غ�����
	final static int ������ = 50000;
	final static int ���� = 10000;
	final static int õ�� = 1000;
	final static int ����� = 500;
	final static int ��� = 100;
	final static int ���ʿ� = 50;
	final static int �ʿ� = 10;
	final static int �Ͽ� = 1;
	
	public static void main (String args[])  {
		int res, money;
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��Ͻÿ�>>");
		money = scanner.nextInt();
		
		res = money/������; // �������� ���� ���
		money = money%������; // money ����
		if(res > 0) {
			System.out.println("�������� "+ res + "��"); // �������� �ż� ǥ��
		}
		res = money/����; // ������ ���� ���
		money = money%����; // money ����
		if(res > 0) {
			System.out.println("������ "+ res + "��"); // ������ �ż� ǥ��
		}
		res = money/õ��; // õ���� ���� ���
		money = money%õ��; // money ����
		if(res > 0) {
			System.out.println("õ���� "+ res + "��"); // õ���� �ż� ǥ��
		}
		res = money/�����; // ����� ���� ���
		money = money%�����; // money ����
		if(res > 0) {
			System.out.println("����� "+ res + "��"); // ����� ���� ǥ��
		} 
		res = money/���; // ��� ���� ���
		money = money%���; // money ����		
		if(res > 0) {
			System.out.println("��� "+ res + "��"); // ��� ���� ǥ��
		}
		res = money/���ʿ�; // ���ʿ� ���� ���
		money = money%���ʿ�; // money ����	
		if(res > 0) {
			System.out.println("���ʿ� "+ res + "��"); // ���ʿ� ���� ǥ��
		}
		res = money/�ʿ�; // �ʿ� ���� ���
		money = money%�ʿ�; // money ����	
		if(res > 0) {
			System.out.println("�ʿ� "+ res + "��"); // �ʿ� ���� ǥ��
		}
		res = money/�Ͽ�; // �Ͽ� ���� ���
		money = money%�Ͽ�; // money ����	
		if(res > 0) {
			System.out.println("�Ͽ� "+ res + "��"); // �Ͽ� ���� ǥ��
		}
		
		scanner.close();
	}
}
