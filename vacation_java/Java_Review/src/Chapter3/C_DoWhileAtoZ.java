package Chapter3;
/*
 * ���α׷��� : A to Z (Do-While)
 * */
public class C_DoWhileAtoZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'a';
		do{
			System.out.print(c + " ");
			c = (char) (c + 1);
		}while(c <= 'z');
	}

}
