package Chapter3_Practice;
/*
 * ���α׷��� : 4*4 �� 2���� �迭�� ����� �̰��� 1~10���� ������ ������ �����ϰ� �����Ͽ� ���� 16���� �迭�� �����ϰ�,
 * 			 2���� �迭�� ȭ�鿡 ����϶�
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
