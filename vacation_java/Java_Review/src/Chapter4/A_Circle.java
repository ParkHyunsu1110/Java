package Chapter4;
/*
 * ���α׷��� : ���ڿ� ������ ���� ���ϱ�
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
		pizza.name = "�ڹ� ����";
		System.out.println(pizza.name + "�� ������" + pizza.getArea());
		
		Circle donut = new Circle();
		donut.radius = 2;
		donut.name = "�ڹ� ����";
		System.out.println( donut.name + "�� ������ " + donut.getArea());
	}

}
