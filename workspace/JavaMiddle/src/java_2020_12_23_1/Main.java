package java_2020_12_23_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int randomNum;
		System.out.println("������ �����մϴ�!");
		boolean loop = true;
		int toN = 1;
		
		while(loop) {
			System.out.println("�θ� ���� �Է��ϼ���.");
			System.out.print("������� ����!");
			int num = sc.nextInt();
			if( num < 1 || 3 < num) {System.out.println("1���� 3�� ���� ������ �Է��� �ּ���.\n�ٽ� �����մϴ�!!"); continue;}
			for(int i=0; i<num; i++) {
				System.out.println(toN); toN++;
				if(toN == 31) { System.out.println("����ڰ� �й��Ͽ����ϴ�."); return;}
			}
			randomNum = random.nextInt(3) + 1;
			System.out.println("��ǻ���� ����!" + randomNum);
			for(int i=0; i<randomNum; i++) {
				System.out.println(toN); toN++;
				if(toN == 31) { System.out.println("��ǻ�Ͱ� �й��Ͽ����ϴ�."); return;}
			}
		}
	}
}
