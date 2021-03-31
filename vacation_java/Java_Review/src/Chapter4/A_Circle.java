package Chapter4;
/*
 * 프로그램명 : 피자와 도넛의 넓이 구하기
 * */
class Circle{
	int radius;
	String name;
	public double getArea() {
		return 3.14 * radius * radius;
	}
}
public class A_Circle {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "자바 피자";
		System.out.println(pizza.name + "의 면적은" + pizza.getArea());
		
		Circle donut = new Circle();
		donut.radius = 2;
		donut.name = "자바 도넛";
		System.out.println( donut.name + "의 면적은 " + donut.getArea());
	}

}
