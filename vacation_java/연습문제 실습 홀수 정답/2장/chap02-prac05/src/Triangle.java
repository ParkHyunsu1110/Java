import java.util.Scanner;

public class Triangle {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� 3���� �Է��Ͻÿ�>>");
		int l1 = scanner.nextInt();
		int l2 = scanner.nextInt();
		int l3 = scanner.nextInt();
		if ((l1+12)<l3 || (l1+l3)<l2 ||(l2+l3)<l1) // �κ��� ���� �ٸ� �Ѻ����� ���� ���
			System.out.println("�ﰢ���� ���� �� �����ϴ�.");
		else
			System.out.println("�ﰢ���� �˴ϴ�");
		
		scanner.close();
	}
}
