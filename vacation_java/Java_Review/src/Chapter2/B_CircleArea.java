package Chapter2;

import java.util.Scanner;

public class B_CircleArea {
	public static double Area(double x) {
		final double PI = 3.141592;
		return x*x*PI;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("반지름을 입력해 주세요.");
		double r = scanner.nextDouble();
		double area;
		area = Area(r);
		System.out.println(area);
		scanner.close();
	}
}
