package Basic;
import java.util.*;
public class SimpleCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����ȣ�� �Է��� �ּ���.(��, +, -, *, / �� �Է��� �ּ���.)");
		String operation = sc.next();
		System.out.println("���� �Է��� �ּ���.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result=0;
		switch(operation) {
			case "+": result = (num1 + num2); break;
			case "-": result = (num1 - num2); break;
			case "*": result = (num1 * num2); break;
			case "/": result = (num1 / num2); break;
		}
		System.out.println("Result : " + result);
	}
}
