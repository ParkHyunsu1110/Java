package Chapter4;
/*
 * 프로그램명 : 사각형 넓이 구하기
 * */
import java.util.Scanner;

class Rectangle {
	int width;
	int height;
	public int getArea() {
		return width*height;
	}
}
public class B_Rectangle {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Scanner scanner = new Scanner(System.in);
		System.out.print("가로 세로 입력하세요.>>");
		rect.width = scanner.nextInt(); rect.height = scanner.nextInt();
		System.out.println("사각형의 면적은 " + rect.getArea());
		scanner.close();
	}
}
