package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ����� ������ ¦�� �̷絵�� 2���� �迭 �ۼ��ϰ�, ���� �̸� �Է� �޾Ƽ�, ���� ����ϰ� ��.
 * 			 ���� '�׸�'�� �Է� ������ ������.
 * */
public class Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String course[] = {"java", "c++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�"};
		int score[] = {95, 88, 76, 62, 55};
		String input = " ";
		int j = 0;
		while(true) {
			System.out.print("�����̸�.>>");
			input = scanner.next();
			if(input.equals("�׸�")==true) break;
			
			for(int i = 0; i < course.length; i++) {
				if(input.equals(course[i])==true) {
					System.out.println(course[i] + "�� ������ " + score[i]);
					j = 1;
				}
			}
			if(j == 0) System.out.println("���� �����Դϴ�.");
		}
		scanner.close();
	}

}
