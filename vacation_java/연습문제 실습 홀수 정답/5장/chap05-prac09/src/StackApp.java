import java.util.Scanner;

public class StackApp {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� ���� ���� ������ ũ�� �Է� >> ");
		int n = scanner.nextInt();
		
		StringStack ss = new StringStack(n); // n���� ���ڿ��� ���� ������ ���� ����
		
		while(true) {
			System.out.print("���ڿ� �Է� >> ");
			String str = scanner.next();
			if(str.equals("�׸�"))
				break;
			boolean res = ss.push(str); // ���ÿ� ����
			if(res == false) {
				System.out.println("������ �� ���� Ǫ�� �Ұ�!");
			}
		}
		
		System.out.print("���ÿ� ����� ��� ���ڿ� �� : ");
		int len = ss.length(); // ���� ���ÿ� ����� ���ڿ� ����
		for(int i=0; i<len; i++) { // ���ÿ� ����� ������ŭ ����
			System.out.print(ss.pop() + " "); // ���ÿ��� ���Ͽ� ���
		}

		scanner.close();
	}
}
