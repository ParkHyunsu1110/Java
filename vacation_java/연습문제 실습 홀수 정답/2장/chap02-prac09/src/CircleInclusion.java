import java.util.Scanner;

public class CircleInclusion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �߽ɰ� ������ �Է�>>");
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		double radius = scanner.nextDouble();
		
		System.out.print("�� �Է�>>");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		
		double distance = Math.sqrt((x-x2)*(x-x2) + (y-y2)*(y-y2));
		if(distance < radius)
			System.out.print("�� (" + x2 + ", " + y2 + ")�� �� �ȿ� �ִ�.");
		else
			System.out.print("�� (" + x2 + "," + y2 + ")�� �� �ۿ� �ִ�.");

		scanner.close();
	}

}
