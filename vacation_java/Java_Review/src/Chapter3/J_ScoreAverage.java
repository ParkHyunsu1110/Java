package Chapter3;

import java.util.Scanner;

/*
 * ���α׷��� : 2���� �迭�� �г⺰�� 1,2 �б� ���� �Է��� �� 4�Ⱓ ��ü ���� ��� ����ϱ�.
 * */
public class J_ScoreAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double score [][] = {{3.3, 3.4},	//4*2 �迭
							 {3.5, 3.6},
							 {3.7, 4.0},
							 {4.1, 4.2}};
		double sum = 0;
		for(int year = 0; year < score.length; year++)
			for(int term = 0; term < score[year].length; term++)
				sum += score[year][term];
		int n = score.length;
		int m = score[0].length;
		System.out.println("4�� ��ü ���� ����� " + sum/(n*m));
	}
}
