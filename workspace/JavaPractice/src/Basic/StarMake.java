package Basic;
import java.util.Scanner;
public class StarMake {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하시오. : ");
		int height = scanner.nextInt();
		for(int i = 1; i<=height; i++) {
			for(int j = 1; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
		for(int i = height; i>0; i--) {
			for(int j = i; j>0; j--)
				System.out.print("*");
			System.out.println();
		}
	}
}