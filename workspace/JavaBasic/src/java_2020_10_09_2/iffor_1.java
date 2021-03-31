package java_2020_10_09_2;
import java.util.Scanner;
public class iffor_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요. : ");
		int age = scanner.nextInt();
		if( age >= 20) {
			System.out.println("성인");
			if( age % 2 == 0) System.out.println("나이가 짝수인 성인");
			else System.out.println("나이가 홀수인 성인");
		}else {
			System.out.println("미성년자");
			if( age % 2 == 0) System.out.println("나이가 짝수인 미성년자");
			else System.out.println("나이가 홀수인 미성년자");
		}
	}
}
