package Chapter4;
/*
 * ���α׷��� : 2 ���� �����ڸ� ���� ���� ���� ���ϱ�
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
		C_What_Const pizza = new C_What_Const(10, "�ڹ�����");
		
		double area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + area);
		
		C_What_Const donut = new C_What_Const();
		donut.name = "��������";
		area = donut.getArea();
		System.out.println(donut.name + "�� ������ " + area);
	}

}
