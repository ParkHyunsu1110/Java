package Chapter2;

import java.util.Scanner;

public class K_Grading {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력해 주세요.(0~100)");
		System.out.print("=>"); int score = scanner.nextInt();
		char grade = 0;
		if((100 >= score) && (score >= 90)) grade = 'A';
		else if((90 > score) && (score >= 80)) grade = 'B';
		else if((80 > score) && (score >= 70)) grade = 'C';
		else if((70 > score) && (score >= 60)) grade = 'D';
		else grade = 'F';
		
		System.out.println("당신의 학점은 " + grade + "입니다.");
	}
}