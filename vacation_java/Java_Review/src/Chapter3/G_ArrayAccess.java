package Chapter3;
/*
 * ���α׷��� : ����� �Է� �޾Ƽ� �迭�� �����ϰ�, ���� ū ���� ����ϴ� ���α׷� �ۼ�.
 * */
import java.util.Scanner;
public class G_ArrayAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5];
		int max = 0;
		System.out.println("��� 5���� �Է��Ͻÿ�.");
		for(int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt();
			if(intArray[i] > max) max = intArray[i];
		}
		System.out.println("���� ū ���� " + max + "�Դϴ�.");
		scanner.close();
	}

}
