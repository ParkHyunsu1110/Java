package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : Scanner�� �̿��Ͽ� ���ĺ��� �Է¹ް� ���ﰢ�� �����
 * */
public class Q04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ҹ��� ���ĺ� �ϳ��� �Է��ϼ���.>>");
		String al = scanner.next();
		char c = al.charAt(0);
		for(int i = c-'a'; i >=0; i--) {
			for(int j = 0; j<=i; j++)
				System.out.print((char)('a'+j));
			System.out.println();
		}
	}
}
