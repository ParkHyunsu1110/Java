package Chapter3;
/*
 * 프로그램명 : 1 ~ 10 까지의 합(If문)
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
