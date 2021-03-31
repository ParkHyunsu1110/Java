package Basic;
import java.util.*;
public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("n = ");
		int isPrime = scanner.nextInt();
		int count;
		int primeCount = 0;
		for( int i = 2; i<= isPrime; i++) {
			count = 0;
			for(int j=1; j<=i; j++) {
				if(i % j==0) count++;
			}		
			if(count==2) primeCount++;
		}
		System.out.println(isPrime + "까지의 소수의 개수는 " + primeCount + "개");
	}
}