package java_2020_10_09_2;
import java.util.Scanner;
public class iffor_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ���. : ");
		int age = scanner.nextInt();
		if( age >= 20) {
			System.out.println("����");
			if( age % 2 == 0) System.out.println("���̰� ¦���� ����");
			else System.out.println("���̰� Ȧ���� ����");
		}else {
			System.out.println("�̼�����");
			if( age % 2 == 0) System.out.println("���̰� ¦���� �̼�����");
			else System.out.println("���̰� Ȧ���� �̼�����");
		}
	}
}
