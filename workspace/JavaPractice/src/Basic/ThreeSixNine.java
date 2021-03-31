package Basic;
import java.util.Scanner;
public class ThreeSixNine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¼ö ÀÔ·Â : ");
		int count = scanner.nextInt();
		for (int i = 1; i <= count; i++) {
			String number = String.valueOf(i);
			System.out.print(number);
			for (int j = 0; j < number.length(); j++) {
				char k = number.charAt(j);
				if (k == '3' || k == '6' || k == '9') {
					System.out.print("Â¦");
				}
			}
			System.out.println();
		}
	}
}
