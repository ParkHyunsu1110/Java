package Chapter4;
/*
 * 프로그램명 : 2 개의 생성자를 가진 원의 넓이 구하기
 * */
public class C_What_Const {
	int radius;
	String name;
	public C_What_Const() {
		radius = 1; name = "";
	}
	public C_What_Const(int r, String n) {
		radius = r; name = n;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C_What_Const pizza = new C_What_Const(10, "자바피자");
		
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		C_What_Const donut = new C_What_Const();
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);
	}

}
