package Chapter3;
/*
 * ���α׷��� : 1 ~ 10 ������ ��(If��)
 * */
public class A_For1to10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int sum = 0;
		for(i = 1; i <= 10; i++) {
			sum += i;
			System.out.print(i);
			if(i <= 9)
				System.out.print(" + ");
			else
				System.out.print(" = " + sum);
		}
	}
}
