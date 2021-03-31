package Chapter2_Practice;
/*
 * 프로그램명 : 두 원이 서로 부딪히는지
 */
import java.util.Scanner;
public class Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 원의 중심과 반지름 입력.>>"); double x1 = scanner.nextDouble(); double y1 = scanner.nextDouble(); double r1 = scanner.nextDouble();
		System.out.print("두번째 원의 중심과 반지름 입력.>>"); double x2 = scanner.nextDouble(); double y2 = scanner.nextDouble(); double r2 = scanner.nextDouble();
		if(Crash_Circle(x1,  y1 ,  r1 , x2 ,  y2 ,  r2) == true) System.out.println("두 원은 서로 겹친다.");
		else System.out.println("두 원은 서로 겹치지 않는다.");
	}
	public static boolean Crash_Circle(double x1, double y1 , double r1 ,double x2 , double y2 , double r2) {
		double dist = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
		double r = r1 + r2;
		if(dist <= r) return true;
		else return false;
	}
}
