package Chapter4;
/*
 * 프로그램명 : static 을 이용한 환율 계산기
 * */
import java.util.Scanner;

class CurrencyConverter{
	private static double rate;
	public static double toDollar(double won) {
		return won/rate;
	}
	public static double toKWR(double dollar) {
		return dollar*rate;
	}
	public static void setRate(double r) {
		rate = r;
	}
}
public class L_CurrencyConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("환율(1달러)>> ");  double rate = scanner.nextDouble();
		CurrencyConverter.setRate(rate);
		System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다");
		System.out.println("$100" + rate + " 는 " + CurrencyConverter.toKWR(100) + "원입니다.");
		scanner.close();
	}

}
