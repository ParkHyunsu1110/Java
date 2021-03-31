package Chapter2;

public class F_AssignmentIncDecOperator {

	public static void main(String[] args) {
		int a=3, b=3,c=3;
		a += 3;
		b *= 3;
		c %=3;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		
		int d = 3;
		a = d++;
		System.out.println("a = " + a + ", d = " + d);
		a = ++d;
		System.out.println("a = " + a + ", d = " + d);
		a = d--;
		System.out.println("a = " + a + ", d = " + d);
		a = --d;
		System.out.println("a = " + a + ", d = " + d);
	}

}
