import java.util.Scanner;

class Add {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a+b;
	}
}

class Mul {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a*b;
	}
}

class Sub {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a-b;
	}
}

class Div {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		int res=0;
		try {
			res = a/b;
		}catch(ArithmeticException e) {
			System.out.print("0���� ���� �� �����ϴ�.");
		}
		
		return res;
	}
}

public class Calc {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ�>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		char operator = scanner.next().charAt(0); // �����ڸ� ���ڷ� ��ȯ
		switch (operator) {
			case '+':
				Add add = new Add();
				add.setValue(a, b);
				System.out.println(add.calculate());
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(a, b);
				System.out.println(sub.calculate());
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(a, b);
				System.out.println(mul.calculate());
				break;
			case '/':
				Div div = new Div();
				div.setValue(a, b);
				System.out.println(div.calculate());
				break;
			default:
				System.out.println("�߸��� �������Դϴ�.");
		}
		
		scanner.close();
	}
}
