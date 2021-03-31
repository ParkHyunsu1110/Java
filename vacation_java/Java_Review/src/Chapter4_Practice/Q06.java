package Chapter4_Practice;
/*
 * 프로그램명 : Circle클래스와 CircleManager클래스 만들고 가장 큰 원 알아내기
 * */
import java.util.Scanner;
class Circle2{
	private double x,y;
	private int radius;
	public Circle2(double x, double y, int radius) {
		this.x=x; this.y=y;
		this.radius=radius;
	}
	public void show() {
		System.out.println("면적이 가장 큰 원은 (" + x + "," + y + ")" + radius);
	}
	public double circleArea() {
		return radius*radius*3.14;
	}
}
public class Q06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle2 c [] = new Circle2[3];
		int num=0;
		for(int i=0; i<c.length; i++) {
			System.out.print("x,y,radius>>");
			double x=scanner.nextDouble();
			double y=scanner.nextDouble();
			int radius=scanner.nextInt();
			c[i] = new Circle2(x,y,radius);
		}
		double max=c[0].circleArea();
		int j=0;
		for(int i=0; i<c.length-1; i++) {
			if(c[i].circleArea()>max) {
				max=c[i].circleArea();
				j=i;
			}
		}
		c[j].show();
		scanner.close();
	}
}