package Chapter3;
/*
 * ���α׷��� : �迭�� ������ ������� �߻��ϴ� ArrayIndexOutOfBoundsException�� ó���ϴ� ���α׷� �ۼ��϶�.
 * */
public class O_ArrayException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] intArray = new int[5];
		intArray[0] = 0;
		try{
			for(int i = 0; i < intArray.length; i++) {
				intArray[i+1] = i + 1 + intArray[i];
				System.out.println("intArray[" + i + "]" + "=" + intArray[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("�迭�� �ε����� ������ ������ϴ�.");
		}
	}

}
