package java_2020_10_09_2;
import java.util.Scanner;
public class iffor_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int number = scanner.nextInt();
		for(int i=1; i<=number; i++) {		
			for(int j=1; j<=i; j++)
				System.out.print(i+" ");		
		}
	}
}
