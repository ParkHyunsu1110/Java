package Chapter3_Practice;
/*
 * 프로그램명 : while, for, do-while 연습
 * */
public class Q01 {
	public static int WhileTest(int a) {
		int sum = 0;
		while(a<100) {
			sum += a;
			a += 2;
		}
		return sum;
	}
	public static int ForTest(int b) {
		int sum = 0;
		for(b = 0; b < 100;) {
			sum += b;
			b += 2;
		}
		return sum;
	}
	public static int DoWhile(int c) {
		int sum = 0;
		c = 0;
		do {
			sum += c;
			c += 2;
		}while(c < 100);
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int While = WhileTest(sum);
		int For = ForTest(sum);
		int doWhile = DoWhile(sum);
		System.out.println("WhileTest = " + While);
		System.out.println("ForTest = " + For);
		System.out.println("DoWhile = " + doWhile);
	}
}
