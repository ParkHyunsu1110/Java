package Chapter3;
/*
 * ���α׷��� : ������ �迭 �ʱ�ȭ ���ִ� �޼ҵ� �ۼ� ��,�迭 ����ϱ�. 
 * */
public class L_ReturnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[];
		intArray = makeArray();
		for(int i = 0; i < intArray.length; i++) 
			System.out.print(intArray[i] + " ");
	}
	public static int[] makeArray() {
		int temp[] = new int[4];
		for(int i = 0; i < temp.length; i++)
			temp[i] = i;
		return temp;
	}
}
