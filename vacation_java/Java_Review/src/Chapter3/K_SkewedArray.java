package Chapter3;
/*
 * 프로그램명 : 비정방형 배열 만들기
 * */
public class K_SkewedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[][] = new int[4][];
		intArray[0] = new int[3];
		intArray[1] = new int[2];
		intArray[2] = new int[3];
		intArray[3] = new int[2];
		
		for(int i = 0; i < intArray.length; i++) 
			for(int j = 0; j < intArray[i].length; j++) 
				intArray[i][j] = (i+1)*10 + j;
		
		for(int i = 0; i < intArray.length; i++) {
			for(int j = 0; j < intArray[i].length; j++)
				System.out.print(intArray[i][j] + " ");
			System.out.println();
		}
	}

}
