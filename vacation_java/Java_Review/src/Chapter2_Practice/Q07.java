package Chapter2_Practice;
/*
 * ���α׷��� : ���簢�� �ȿ� ��ǥ�� ��ġ�ϴ���
 * */
import java.util.Scanner;
public class Q07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� (x,y)�� ��ǥ�� �Է��Ͻÿ�.>>"); int x = scanner.nextInt(); int y = scanner.nextInt();
		if(Is_Rectangle(x,y) == true) System.out.println("(" + x + " , " + y + ") �� �簢�� �ȿ� �ֽ��ϴ�.");
		else System.out.println("(" + x + " , " + y + ") �� �簢�� �ȿ� �����ϴ�.");
	}
	public static boolean Is_Rectangle(int x, int y) {
		if((x>=100 && y >= 100) && (x <= 200 && y <= 200)) return true;
		else return false;
	}
}
