package Chapter3_Practice;
/*
 * ���α׷��� : �ݺ����� �̿��� 369���� �ϱ� 1~99����
 * */
public class Q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<100; i++) {
			if(i>=10) { //10���� ū �� (���ڸ���)
				if(i/10==3||i/10==6||i/10==9) { //10�� �ڸ��� 3, 6, 9 �϶�
					if(i%10==3||i%10==6||i%10==9) System.out.println(i+" �ڼ� ¦¦"); //1�� �ڸ��� 3, 6, 9 �϶�
					else System.out.println(i+ " �ڼ� ¦"); //1�� �ڸ��� 3,6,9�� �ƴ� ��
				}
				
				else if(i%10==3||i%10==6||i%10==9) System.out.println(i+" �ڼ� ¦");
					//10�� �ڸ��� 3, 6, 9�� �ƴѵ� 1�� �ڸ��� 3, 6, 9 �� ��
			}
			
			if(i<10)
				if(i%10==3||i%10==6||i%10==9) System.out.println(i+" �ڼ� ¦"); //1�� �ڸ��� 3,6,9�� ��
		}
	}

}
