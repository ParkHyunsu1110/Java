package Chapter2;

import java.util.Scanner;

public class D_Inforamtion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�̸�, ����, ����, ü��, ���� ���θ� ��ĭ���� �и��Ͽ� �Է��ϼ���.");
		String name = scanner.next();
		String city  = scanner.next();
		int age = scanner.nextInt();
		double weight = scanner.nextDouble();
		boolean isSingle = scanner.hasNextBoolean();
		System.out.println("�̸� : " + name + " , " + "���� : " + city + " , " + "���� : " + age + " , " + "ü�� : " + weight + " , " + "���� : " + isSingle);
		scanner.close();
	}

}
