package Chapter3;
/*
 * ���α׷��� : legth�� ����Ͽ� �迭 ũ�⸸ŭ ������ �Է¹ް�, ����� ���ϴ� ���α׷� �ۼ�.
 * */
import java.util.Scanner;
public class H_ArrayLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5];
		int sum = 0;
		System.out.println(intArray.length + "���� ������ �Է��ϼ���.");
		for(int i = 0; i < intArray.length; i++) intArray[i] = scanner.nextInt();
		for(int i = 0; i < intArray.length; i++) sum += intArray[i];
		
		System.out.println("����� " + (double)sum/intArray.length);
		scanner.close();
	}

}
