package Chapter3;
/*
 * 프로그램명 : legth를 사용하여 배열 크기만큼 정수를 입력받고, 평균을 구하는 프로그램 작성.
 * */
import java.util.Scanner;
public class H_ArrayLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5];
		int sum = 0;
		System.out.println(intArray.length + "개의 정수를 입력하세요.");
		for(int i = 0; i < intArray.length; i++) intArray[i] = scanner.nextInt();
		for(int i = 0; i < intArray.length; i++) sum += intArray[i];
		
		System.out.println("평균은 " + (double)sum/intArray.length);
		scanner.close();
	}

}
