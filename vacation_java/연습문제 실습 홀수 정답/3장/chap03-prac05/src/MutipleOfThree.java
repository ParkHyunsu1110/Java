import java.util.Scanner;

public class MutipleOfThree {
	public static void main (String[] args) {
		int intArray[] = new int[10];
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� ���� 10���� �Է��Ͻÿ�>>");
		for (int i=0; i<intArray.length; i++) 
			intArray[i] = scanner.nextInt();
		
		System.out.print("3�� ����� ");
		for (int i=0; i<intArray.length; i++)
			if (intArray[i] % 3 == 0) // 3���� ������ �������� 0�̸� 3�� ���
				System.out.print(intArray[i] + " ");
		
		scanner.close();
	}
}
