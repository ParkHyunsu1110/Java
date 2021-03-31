package java_2020_12_23_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int randomNum;
		System.out.println("게임을 시작합니다!");
		boolean loop = true;
		int toN = 1;
		
		while(loop) {
			System.out.println("부를 수를 입력하세요.");
			System.out.print("사용자의 숫자!");
			int num = sc.nextInt();
			if( num < 1 || 3 < num) {System.out.println("1에서 3의 범위 내에서 입력해 주세요.\n다시 시작합니다!!"); continue;}
			for(int i=0; i<num; i++) {
				System.out.println(toN); toN++;
				if(toN == 31) { System.out.println("사용자가 패배하였습니다."); return;}
			}
			randomNum = random.nextInt(3) + 1;
			System.out.println("컴퓨터의 숫자!" + randomNum);
			for(int i=0; i<randomNum; i++) {
				System.out.println(toN); toN++;
				if(toN == 31) { System.out.println("컴퓨터가 패배하였습니다."); return;}
			}
		}
	}
}
