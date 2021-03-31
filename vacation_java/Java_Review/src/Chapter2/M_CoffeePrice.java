package Chapter2;

import java.util.Scanner;

public class M_CoffeePrice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("무슨 커피 드릴까요??");
		System.out.print("=>"); String coffee = scanner.next();
		int price = 0;
		switch(coffee) {
			case "에스프레소": case "카푸치노": case "카페라테": price = 3500; break;
			case "아메리카노": price = 2000; break;
			default: System.out.println("메뉴에 없는 커피입니다. 재주문해 주십시오.");
		}
		if(price != 0) System.out.println("주문하신 " + coffee + "는 " + price + "원 입니다.");
		else System.out.println("주문하지 않으셨습니다. 주문해 주세요");
		scanner.close();
	}
}
