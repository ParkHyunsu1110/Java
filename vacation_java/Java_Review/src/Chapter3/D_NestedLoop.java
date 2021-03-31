package Chapter3;
/*
 * 프로그램명 : 이중 중첩 반복문을 사용하여 구구단 출력
 * */
public class D_NestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0,j = 0;
		int prod = i*j;
		for(i = 1; i <= 9; i++) {
			for(j = 1; j <= 9; j ++){
				System.out.print(j + " * " + i + " = " + prod);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
