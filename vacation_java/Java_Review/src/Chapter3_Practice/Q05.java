package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ���� ���� 10�� �Է� �޾� �迭�� �����ϰ�, �迭�� �ִ� �����߿��� 3�� ����� ����϶�
 * */
public class Q05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] n = new int [10];
		System.out.print("���� ���� 10�� �Է��Ͻÿ�.>>"); 
		for(int i = 0; i<n.length; i++) 
			n[i] = scanner.nextInt();
		System.out.print("3�� ���>>");
		for(int j = 0; j<n.length; j++)
			if(n[j]%3 == 0)
				System.out.print(n[j] + " ");
		System.out.println();
	}
}
