package Chapter4;
/*
 * 프로그램명 : Circle 객체 배열 만들기
 * */

class fCircle{
	int radius;
	public fCircle(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}
public class F_Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fCircle [] c;
		c = new fCircle[5];
		for(int i=0; i<c.length; i++)
			c[i] = new fCircle(i);
		for(int i=0; i<c.length; i++)
			System.out.print((int)(c[i].getArea()) + " ");
	}

}
