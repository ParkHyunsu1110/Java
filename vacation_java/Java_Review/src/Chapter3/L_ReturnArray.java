package Chapter3;
/*
 * 프로그램명 : 일차원 배열 초기화 해주는 메소드 작성 후,배열 출력하기. 
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
