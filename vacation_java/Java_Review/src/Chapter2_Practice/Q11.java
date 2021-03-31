package Chapter2_Practice;
/*
 * 프로그램명 : 입력한 달에 따른 계절 나타내기
 * */
import java.util.Scanner;
public class Q11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("If_Else 문으로 알아보려면 i, Switch문으로 알아보려면 s를 입력해 주세요.>>");
		String choose = scanner.next();
		if(choose.equals("i")) {
			System.out.print("달을 입력하세요(1~12).>>"); int month = scanner.nextInt();
			if(If_Weather(month) == 1) System.out.println("선택하신 계절은 봄입니다.");
			else if(If_Weather(month) == 2) System.out.println("선택하신 계절은 여름입니다.");
			else if(If_Weather(month) == 3) System.out.println("선택하신 계절은 가을입니다.");
			else if(If_Weather(month) == 4) System.out.println("선택하신 계절은 겨울입니다.");
			else System.out.println("달을 잘못 입력하셨습니다.");
		}else if(choose.equals("s")) {
			System.out.print("달을 입력하세요(1~12).>>"); int month = scanner.nextInt();
			if(Switch_Weather(month) == 1) System.out.println("선택하신 계절은  봄입니다.");
			else if(Switch_Weather(month) == 2) System.out.println("선택하신 계절은 여름 입니다.");
			else if(Switch_Weather(month) == 3) System.out.println("선택하신 계절은  가을입니다.");
			else if(Switch_Weather(month) == 4) System.out.println("선택하신 계절은  겨울입니다.");
			else System.out.println("달을 잘못 입력하셨습니다.");
		}else System.out.println("알아보지 않기로 결정....");
	}
	public static int If_Weather(int w) {
		if(w>=3 && w<=5) return 1;
		else if(w>=6 && w <= 8) return 2;
		else if(w>= 9 && w <= 11) return 3;
		else if(w == 12 || ( w >=1 && w <= 2 )) return 4;
		else return 5;
	}
	public static int Switch_Weather(int m) {
		int w;
		switch(m) {
			case 3: case 4: case 5: w = 1; break;
			case 6: case 7: case 8: w = 2; break;
			case 9: case 10: case 11: w = 3; break;
			case 1: case 2: case 12: w = 4; break;
			default: w = 5; break;
		}
		return w;
	}
}
