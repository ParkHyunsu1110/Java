package Chapter2_Practice;
/*
 * 프로그램명 : 직사각형 안에 좌표가 위치하는지
 * */
import java.util.Scanner;
public class Q07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("점 (x,y)의 좌표를 입력하시오.>>"); int x = scanner.nextInt(); int y = scanner.nextInt();
		if(Is_Rectangle(x,y) == true) System.out.println("(" + x + " , " + y + ") 는 사각형 안에 있습니다.");
		else System.out.println("(" + x + " , " + y + ") 는 사각형 안에 없습니다.");
	}
	public static boolean Is_Rectangle(int x, int y) {
		if((x>=100 && y >= 100) && (x <= 200 && y <= 200)) return true;
		else return false;
	}
}
