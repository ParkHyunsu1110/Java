package Chapter2_Practice;
/*
 * ���α׷��� : ��ǥ�� �� �ȿ� ��ġ�ϴ°�?
 * */
import java.util.Scanner;
public class Q09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �߽ɰ� ������ �Է�.>>"); double ox = scanner.nextDouble(); double oy = scanner.nextDouble(); double r = scanner.nextDouble();
		System.out.print("�� �Է�>>"); double x = scanner.nextDouble(); double y = scanner.nextDouble();
		
		if(In_Circle(ox,x,oy,y,r) == true) System.out.println("(" + x + " , " + y +") �� �� �ȿ� �ֽ��ϴ�.");
		else System.out.println("(" + x + " , " + y +") �� �� �ȿ� �����ϴ�.");
		
	}
	public static boolean In_Circle(double ox, double oy, double r, double x, double y) {
		double dist;
		dist = Math.sqrt((ox - x)*(ox - x) + (oy - y)*(oy - y));
		if(dist<= r) return true;
		else return false;
	}
}
