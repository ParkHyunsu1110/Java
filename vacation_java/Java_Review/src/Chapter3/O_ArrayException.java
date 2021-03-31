package Chapter3;
/*
 * 프로그램명 : 배열의 범위를 벗어났을때 발생하는 ArrayIndexOutOfBoundsException을 처리하는 프로그램 작성하라.
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
			System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
		}
	}

}
