package java_Basic_Practice;
import java.util.*;
public class java_Basic_Practice_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 크기 : ");
		int fruitsSize = sc.nextInt();
		
		Vector<String> fruits = new Vector<>();
		for(int i=0; i<fruitsSize; i++) {
			System.out.print("과일 이름 입력 : ");
			String fruitName = sc.next();
			fruits.add(fruitName);
		}
		
		System.out.println("몇번째 과일을 가져올까요??");
		int fruitsIndex = sc.nextInt();
		
		System.out.println(fruits.get(fruitsIndex-1));
	}
}
