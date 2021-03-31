package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 과목과 점수가 짝을 이루도록 2개의 배열 작성하고, 과목 이름 입력 받아서, 점수 출력하게 함.
 * 			 만약 '그만'을 입력 받으면 종료함.
 * */
public class Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String course[] = {"java", "c++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score[] = {95, 88, 76, 62, 55};
		String input = " ";
		int j = 0;
		while(true) {
			System.out.print("과목이름.>>");
			input = scanner.next();
			if(input.equals("그만")==true) break;
			
			for(int i = 0; i < course.length; i++) {
				if(input.equals(course[i])==true) {
					System.out.println(course[i] + "의 점수는 " + score[i]);
					j = 1;
				}
			}
			if(j == 0) System.out.println("없는 과목입니다.");
		}
		scanner.close();
	}

}
