package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : for-each ���� Ȱ���ض�.
 * */
public class I_Foreach {
	enum Week{��, ȭ, ��, ��, ��, ��, ��};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] n = {1,2,3,4,5};
		int sum = 0;
		for(int k:n) {
			System.out.print(k + " ");
			sum += k;
		}
		System.out.println("���� " + sum + "�Դϴ�.");
		
		String name[] = {"���","��","�ٳ���","ü��","����","����"};
		for(String fruits:name)
			System.out.print(fruits + " ");
		System.out.println();
		
		for(Week day: Week.values()) 
			System.out.print(day + "���� ");
		System.out.println();
	}

}
