package java_2020_10_05_3;
import java.util.Scanner;
public class If_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���̸� �Է��ϼ���.");
		int age = scanner.nextInt();
		
		if (1 <= age && age <= 7) System.out.println("����");
		
		else if (8 <= age && age <= 13) System.out.println("�ʵ��л�");
		
		else if (14 <= age && age <= 16) System.out.println("���л�");
		
		else if (17 <= age && age <= 19) System.out.println("����л�");
		
		else System.out.println("����");
	}
}
