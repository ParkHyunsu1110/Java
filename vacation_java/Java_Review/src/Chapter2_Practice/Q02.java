package Chapter2_Practice;
/*
 * 프로그램명 : 십의자리수 == 일의자리수 ??
 * */
import java.util.Scanner;
public class Q02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("2자리수 정수 입력(10~99)>>");	int n = scanner.nextInt();
		if(n>=10 && n <= 99) {
			if(Double_Digit(n) == true) System.out.println("Yes!! 10의 자리와 1의 자리가 같습니다!!");
			else System.out.println("No!! 10의 자리와 1의자리가 다릅니다!!");
		}else System.out.println("범위 밖의 수 입니다 다시 입력해 주세요.");
	}
	public static boolean Double_Digit(int n) {
		int t = 0, o = 0;
		t = n /10;
		o = n % 10;
		if(t == o) return true;
		else return false;
	}
}
