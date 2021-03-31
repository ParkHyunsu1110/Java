package Basic;
import java.util.*;
public class SimpleCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("연산기호를 입력해 주세요.(단, +, -, *, / 만 입력해 주세요.)");
		String operation = sc.next();
		System.out.println("수를 입력해 주세요.");
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
