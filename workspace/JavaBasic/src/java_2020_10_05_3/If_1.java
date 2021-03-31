package java_2020_10_05_3;
import java.util.Scanner;
public class If_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나이를 입력하세요.");
		int age = scanner.nextInt();
		
		if (1 <= age && age <= 7) System.out.println("유아");
		
		else if (8 <= age && age <= 13) System.out.println("초등학생");
		
		else if (14 <= age && age <= 16) System.out.println("중학생");
		
		else if (17 <= age && age <= 19) System.out.println("고등학생");
		
		else System.out.println("성인");
	}
}
