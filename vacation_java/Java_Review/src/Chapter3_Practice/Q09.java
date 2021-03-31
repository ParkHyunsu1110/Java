package Chapter3_Practice;
/*
 * 프로그램명 : 4*4 의 2차원 배열을 만들고 이곳에 1~10까지 범위의 정수를 랜덤하게 생성하여 정수 16개를 배열에 저장하고,
 * 			 2차원 배열을 화면에 출력하라
 * */
public class Q09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				array[i][j] = (int)(Math.random()*10+1);
				System.out.print(array[i][j]);
				if(array[i][j] < 10) System.out.print("    ");
				else System.out.print("   ");
			}
			System.out.println();
		}
	}

}
