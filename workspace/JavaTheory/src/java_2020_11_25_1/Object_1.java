package java_2020_11_25_1;

import java.util.Vector;

public class Object_1 {
	public static void main(String[] args) {
		Vector<Object> circle = new Vector<>();
		int r = 17;
		String title = "Circle";
		double PI = 3.141592;
		double area;
		circle.add(r);
		circle.add(title);
		circle.add(PI);
		System.out.println((String)(circle.get(1)) + " Area");
		System.out.println((int)(circle.get(0)) * (int)(circle.get(0)) * (double)(circle.get(2)));
	}
}
