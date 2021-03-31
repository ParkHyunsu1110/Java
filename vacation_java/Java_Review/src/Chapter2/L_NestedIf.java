package Chapter2;

import java.util.Scanner;

public class L_NestedIf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요.(0~100)");
		System.out.print("=>"); int score = scanner.nextInt();
		System.out.println("학년을 입력하세요.");
		System.out.print("=>"); int year = scanner.nextInt();
		if(score>=60) {
			if(year != 4) System.out.println("축하드립니다. 합격입니다.");
			else if(score >= 70) System.out.println("축하드립니다. 합격입니다.");
			else System.out.println("불합격입니다.");
		}else System.out.println("불합격입니다.");
		scanner.close();
	}

}
