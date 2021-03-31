package Basic;
import java.util.*;
public class Multiple3To5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("범위 입력 : ");
		int numRange = sc.nextInt();
		int sum=0;
		for(int i=1; i<=numRange; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
			else
				continue;
		}
		System.out.println("Result : " + sum);
	}
}
