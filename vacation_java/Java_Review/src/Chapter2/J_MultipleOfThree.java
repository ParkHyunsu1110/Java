package Chapter2;

import java.util.Scanner;

public class J_MultipleOfThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("임의의 양의 정수를 입력해 주세요.");
		int i = scanner.nextInt();
		if((i % 3 == 1) || (i % 3 == 2)) System.out.println(i + "는 3의 배수가 아닙니다");
		else System.out.println(i + "는 3의 배수입니다.");
		scanner.close();
	}
}
