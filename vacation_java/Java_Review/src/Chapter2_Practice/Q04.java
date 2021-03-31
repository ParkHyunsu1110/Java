package Chapter2_Practice;
/*
 * 프로그램명 : 중간값 구하기
 * */
import java.util.Scanner;
public class Q04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("세 개의 정수를 입력하세요. >>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		System.out.println("중간 값은 " + Middle(a,b,c));
	}
	public static int Middle(int x, int y, int z) {
		int middle = 0;
		if(x<y) {
			if(y<z) middle = y;
			else {
				if(x<z) middle = z;
				else middle = x;
			}
		}else {
			if(x<z) middle = x;
			else {
				if(y<z) middle = z;
				else middle = y;
			}
		}
		return middle;
	}
}
