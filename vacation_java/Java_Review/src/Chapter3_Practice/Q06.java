package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ���� �׼� �Է� �޾� ���� ���� �� ���� ��ȯ�Ǵ��� ����϶�.
 * */
public class Q06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		int tmp = 0;
		System.out.print("�ݾ��� �Է��Ͻÿ�.>>"); int n = scanner.nextInt();
		for(int i = 0; i< unit.length; i++) {
			if(n/unit[i] != 0) 
				System.out.println(unit[i] + " �� ¥�� : " + n/unit[i] + "��");
			n %= unit[i];
		}
		scanner.close();
	}
}
