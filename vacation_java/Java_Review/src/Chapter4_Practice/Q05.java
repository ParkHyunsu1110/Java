package Chapter4_Practice;
/*
 * 프로그램명 : Circle클래스와 CircleManager클래스 완성하기
 * */
import java.util.*;
class Circle {
	private double x,y;
	private int radius;
	public Circle(double x, double y,int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public void show() { System.out.println("(" + x + "," + y + ") " + radius);}
}
public class Q05 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Circle c [] = new Circle[3];
		
		for(int i=0; i<c.length; i++) {
			System.out.print("x, y, radius>>");
			double x=scanner.nextDouble();
			double y=scanner.nextDouble();
			int radius=scanner.nextInt();
			c[i] = new Circle(x,y,radius);
		}
		for(int i=0; i<c.length; i++) c[i].show();
		scanner.close();
	}

}
