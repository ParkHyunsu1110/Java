package Chapter2_Practice;
/*
 * ���α׷��� : �����ڸ��� == �����ڸ��� ??
 * */
import java.util.Scanner;
public class Q02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("2�ڸ��� ���� �Է�(10~99)>>");	int n = scanner.nextInt();
		if(n>=10 && n <= 99) {
			if(Double_Digit(n) == true) System.out.println("Yes!! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�!!");
			else System.out.println("No!! 10�� �ڸ��� 1���ڸ��� �ٸ��ϴ�!!");
		}else System.out.println("���� ���� �� �Դϴ� �ٽ� �Է��� �ּ���.");
	}
	public static boolean Double_Digit(int n) {
		int t = 0, o = 0;
		t = n /10;
		o = n % 10;
		if(t == o) return true;
		else return false;
	}
}
