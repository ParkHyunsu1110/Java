package Chapter2_Practice;
/*
 * ���α׷��� : �� ���� ���� �ε�������
 */
import java.util.Scanner;
public class Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ���� �߽ɰ� ������ �Է�.>>"); double x1 = scanner.nextDouble(); double y1 = scanner.nextDouble(); double r1 = scanner.nextDouble();
		System.out.print("�ι�° ���� �߽ɰ� ������ �Է�.>>"); double x2 = scanner.nextDouble(); double y2 = scanner.nextDouble(); double r2 = scanner.nextDouble();
		if(Crash_Circle(x1,  y1 ,  r1 , x2 ,  y2 ,  r2) == true) System.out.println("�� ���� ���� ��ģ��.");
		else System.out.println("�� ���� ���� ��ġ�� �ʴ´�.");
	}
	public static boolean Crash_Circle(double x1, double y1 , double r1 ,double x2 , double y2 , double r2) {
		double dist = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
		double r = r1 + r2;
		if(dist <= r) return true;
		else return false;
	}
}
