package Chapter2_Practice;
/*
 * ���α׷��� : ���簢���� ���簢���� �浹�ϴ��� ���ϱ�
 * */
import java.util.Scanner;
public class Q08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ��ǥ�� �Է��� �ּ���.>>"); int x1 = scanner.nextInt(); int y1 = scanner.nextInt();
		System.out.print("�ι�° ��ǥ�� �Է��� �ּ���.>>"); int x2 = scanner.nextInt(); int y2 = scanner.nextInt();
		
		if(Crash_Rectangle(x1,x2,y1,y2) == true) System.out.println("�簢���� �����մϴ�.");
		else System.out.println("�簢���� �浹���� �ʽ��ϴ�.");
		
	}
	public static boolean Crash_Rectangle(int x1, int y1, int x2, int y2) {
		if((x1 >= 100 && x1 <= 200) && ( y1 >= 100 && y1 <= 200)) {
			if((x2 >= 100 && x2 <= 200) && (y2 >= 100 && y2 <= 200)) return true;
				else return false;
		}else return false;
	}

}
