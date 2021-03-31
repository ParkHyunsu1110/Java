package Chapter3_Practice;
/*
 * 프로그램명 : 2차원 배열 n 출력
 * */
public class Q02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n [][] = 	{{1},
						{1,2,3},
						{1},
						{1,2,3,4},
						{1,2}};
		for(int i = 0; i<n.length; i++) {
			for(int j =0; j<n[i].length; j++)
				System.out.print(n[i][j] + " ");
			System.out.println();
		}
	}

}
