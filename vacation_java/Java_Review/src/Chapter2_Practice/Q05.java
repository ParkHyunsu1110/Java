package Chapter2_Practice;
/*
 * ���α׷��� : �ﰢ�� �������� �Ǻ��ϱ�
 * */
import java.util.Scanner;
public class Q05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� 3���� �Է��ϼ���.>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		if(Is_Triangle(a,b,c) == true) System.out.println("�ﰢ���� �ʴϴ�.");
		else System.out.println("�ﰢ���� ���� �ʽ��ϴ�.");
	}
	public static boolean Is_Triangle(int x, int y, int z) {
		int max = 0, mid = 0, min = 0;
		int tri;
		if(x<y) {
			if(y<z) { 
				max = z; mid = y; min = x;
				if(max < mid + min) return true;
				else return false;
			}
			else {
				max = y; mid = z; min = x;
				if(max < mid + min) return true;
				else return false;
			}
		}else {
			if(x<z) {
				max = z; mid = x; min = y;
				if(max < mid + min) return true;
				else return false;
			}
			else {
				max = x; mid = z; min = y;
				if(max < mid + min) return true;
				else return false;
			}
		}
	}
}
