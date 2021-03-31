interface Shape {
	final double PI = 3.14;
	void draw(); // ������ �׸��� �߻� �޼ҵ�
	double getArea(); // ������ ������ �����ϴ� �߻� �޼ҵ�
	default public void redraw() { // ����Ʈ �޼ҵ�
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw();	
	}
}

class Circle implements Shape {
	private int radius; // ������
	
	public Circle(int radius) { 
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("�������� " + radius + "�� ���Դϴ�.");
	}
	
	@Override
	public double getArea() { 
		return PI*radius*radius;
	}
}


public class Shapes {
	 public static void main(String [] args) {
		Shape donut = new Circle(10); // �������� 10�� �� ��ü
		donut.redraw();
		System.out.println("������ " + donut.getArea());
	}
}
