package Chapter4_Practice;
/*
 * 프로그램명 : static 메소드, 배열 다루기, 배열 리턴
 * */
class ArrayUtil {
	public static int [] concat(int[] a, int[] b) {
		int [] c = new int[a.length+b.length];
		for(int i=0; i<a.length; i++)
			c[i] = a[i];
		for(int i=a.length; i<c.length; i++)
			c[i] = b[i-a.length];
		return c;
	}
	public static void print(int[] a) {
		System.out.print("[" + " ");
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println("]");
	}
}
public class Q09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {1, 5, 7, 9};
		int [] array2 = {3, 6, -1, 100, 77};
		int [] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}

}
