package Chapter2;

import java.util.Scanner;

public class I_SuccessOrFail {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("시험점수를 입력해 주세요.");
		System.out.print("=>");
		double score = scanner.nextDouble();
		if(score >= 80) System.out.println("축하합니다!" + score + "점으로 합격입니다!!");
		else System.out.println("아쉽네요 조금 더 노력해봐요!!");
		scanner.close();
	}
}
