package Chapter4;
/*
 * ���α׷��� : �簢�� ���� ���ϱ�
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
		System.out.print("���� ���� �Է��ϼ���.>>");
		rect.width = scanner.nextInt(); rect.height = scanner.nextInt();
		System.out.println("�簢���� ������ " + rect.getArea());
		scanner.close();
	}
}
