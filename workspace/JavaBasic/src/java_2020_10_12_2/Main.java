package java_2020_10_12_2;

public class Main {

	public static void main(String[] args) {
//		try {
//			int num1 = 4;
//			int num2 = 0;
//			System.out.println(num1 + " �� " + num2 + " = " + (num1/num2));
//		} catch(ArithmeticException e){
//			System.out.println("0���� ������ ���ܰ� �߻��Ͽ����ϴ�.");
//			e.printStackTrace();
//		}
		try {
			int num = -2;
			if( num < 0 ) {
				throw new MinusException();
			}
		} catch(MinusException e) {
			e.printStackTrace();
		}
	}
}
