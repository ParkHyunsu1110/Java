import java.util.Scanner;
public class Rectangle {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� (x,y)�� ��ǥ�� �Է��Ͻÿ�>>");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if (x >= 100 && x <=200 && y >= 100 && y <= 200) // ���� �簢�� ���� �ִ� ���
			System.out.println("(" + x + "," + y + ")�� �簢�� �ȿ� �ֽ��ϴ�.");
		else
			System.out.println("(" + x + "," + y + ")�� �簢�� �ȿ� �����ϴ�.");
		
		scanner.close();
	}
}
