package Chapter2_Practice;
/*
 * 프로그램명 : 좌표가 원 안에 위치하는가?
 * */
import java.util.Scanner;
public class Q09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("원의 중심과 반지름 입력.>>"); double ox = scanner.nextDouble(); double oy = scanner.nextDouble(); double r = scanner.nextDouble();
		System.out.print("점 입력>>"); double x = scanner.nextDouble(); double y = scanner.nextDouble();
		
		if(In_Circle(ox,x,oy,y,r) == true) System.out.println("(" + x + " , " + y +") 는 원 안에 있습니다.");
		else System.out.println("(" + x + " , " + y +") 는 원 안에 없습니다.");
		
	}
	public static boolean In_Circle(double ox, double oy, double r, double x, double y) {
		double dist;
		dist = Math.sqrt((ox - x)*(ox - x) + (oy - y)*(oy - y));
		if(dist<= r) return true;
		else return false;
	}
}
