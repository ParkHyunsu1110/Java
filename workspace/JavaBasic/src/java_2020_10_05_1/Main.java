package java_2020_10_05_1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		System.out.println("입력해 주세요.");
		//String testA = scanner.next();
		//String testA = scanner.nextLine();
		//System.out.println(testA);
		System.out.print("first Number : ");
		int a = 5;		
		String b = scanner.next();		
		System.out.println(a + b);
		System.out.print("second Nimber : ");
		int c = scanner.nextInt();
		System.out.println(a + c);
	}
}
