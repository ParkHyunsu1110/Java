package java_Basic_Practice;
import java.util.*;
public class java_Basic_Practice_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� ũ�� : ");
		int fruitsSize = sc.nextInt();
		
		Vector<String> fruits = new Vector<>();
		for(int i=0; i<fruitsSize; i++) {
			System.out.print("���� �̸� �Է� : ");
			String fruitName = sc.next();
			fruits.add(fruitName);
		}
		
		System.out.println("���° ������ �����ñ��??");
		int fruitsIndex = sc.nextInt();
		
		System.out.println(fruits.get(fruitsIndex-1));
	}
}
