package Chapter3;
/*
 * 프로그램명 : 양수를 입력 받아서 배열에 저장하고, 제일 큰 수를 출력하는 프로그램 작성.
 * */
import java.util.Scanner;
public class G_ArrayAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5];
		int max = 0;
		System.out.println("양수 5개를 입력하시오.");
		for(int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt();
			if(intArray[i] > max) max = intArray[i];
		}
		System.out.println("가장 큰 수는 " + max + "입니다.");
		scanner.close();
	}

}
