package Chapter2;

public class C_Casting {

	public static void main(String[] args) {
		byte b = 127;
		int j = 100;
		System.out.println(b + j);						//227
		System.out.println(10 / 4);						//2
		System.out.println(10.0 / 4);					//2.5
		System.out.println((char)0x12340041);			//16진수 변환
		System.out.println((byte)(b + j));				//-27
		System.out.println((int)2.9 + 1.8);				//3.8
		System.out.println((int)(2.9 + 1.8));			//4
		System.out.println((int)(2.9) + (int)(1.8));	//3
	}

}
