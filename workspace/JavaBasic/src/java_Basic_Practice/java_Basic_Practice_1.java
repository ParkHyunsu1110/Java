package java_Basic_Practice;
import java.util.*;
public class java_Basic_Practice_1 {
	public static void main(String[] args) {
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("입력받을 크기 입력 : ");
			int sizeNumber = scanner.nextInt();
			int sum=0;
			for(int i=0; i<sizeNumber; i++) {
				System.out.print("숫자 입력 : ");
				int number = scanner.nextInt();
				if(number < 0) {
					throw new MinusException();
				}
				sum += number;			
			}
			System.out.println(sum);
		} catch(MinusException e) {
			e.printStackTrace();
		}	
	}
}
