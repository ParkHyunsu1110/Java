package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : Scanner�� ����� *�� �̷��� ���ﰢ�� �����
 * */
public class Q03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���.>>"); int h = scanner.nextInt();
		for(int i = h; i > 0; i--) {
			for(int j = i; j>0; j--) 
				System.out.print("*");
			System.out.println();
		}
	}

}
