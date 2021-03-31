package Chapter2_Practice;
/*
 * 프로그램명 : 직사각형과 직사각형이 충돌하는지 구하기
 * */
import java.util.Scanner;
public class Q08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 좌표를 입력해 주세요.>>"); int x1 = scanner.nextInt(); int y1 = scanner.nextInt();
		System.out.print("두번째 좌표를 입력해 주세요.>>"); int x2 = scanner.nextInt(); int y2 = scanner.nextInt();
		
		if(Crash_Rectangle(x1,x2,y1,y2) == true) System.out.println("사각형과 충졸합니다.");
		else System.out.println("사각형과 충돌하지 않습니다.");
		
	}
	public static boolean Crash_Rectangle(int x1, int y1, int x2, int y2) {
		if((x1 >= 100 && x1 <= 200) && ( y1 >= 100 && y1 <= 200)) {
			if((x2 >= 100 && x2 <= 200) && (y2 >= 100 && y2 <= 200)) return true;
				else return false;
		}else return false;
	}

}
