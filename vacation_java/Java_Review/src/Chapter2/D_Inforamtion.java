package Chapter2;

import java.util.Scanner;

public class D_Inforamtion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
		String name = scanner.next();
		String city  = scanner.next();
		int age = scanner.nextInt();
		double weight = scanner.nextDouble();
		boolean isSingle = scanner.hasNextBoolean();
		System.out.println("이름 : " + name + " , " + "도시 : " + city + " , " + "나이 : " + age + " , " + "체중 : " + weight + " , " + "독신 : " + isSingle);
		scanner.close();
	}

}
