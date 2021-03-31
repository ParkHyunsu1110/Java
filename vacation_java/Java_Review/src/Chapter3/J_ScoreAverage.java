package Chapter3;

import java.util.Scanner;

/*
 * 프로그램명 : 2차원 배열에 학년별로 1,2 학기 성적 입력한 후 4년간 전체 평점 평균 출력하기.
 * */
public class J_ScoreAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double score [][] = {{3.3, 3.4},	//4*2 배열
							 {3.5, 3.6},
							 {3.7, 4.0},
							 {4.1, 4.2}};
		double sum = 0;
		for(int year = 0; year < score.length; year++)
			for(int term = 0; term < score[year].length; term++)
				sum += score[year][term];
		int n = score.length;
		int m = score[0].length;
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));
	}
}
