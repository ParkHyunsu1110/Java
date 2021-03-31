class ArrayUtil {	
	public static int [] concat(int[] a, int[] b) { // �迭 a�� b�� ������ ���ο� �迭 ����
		int tmp [] = new int [a.length + b.length]; // �迭 a�� b�� ���� ũ���� �迭 ����
		for(int i=0; i<a.length; i++) // �迭 a�� tmp�� ����
			tmp[i] = a[i];

		for(int i=0; i<b.length; i++) { // �迭 b�� tmp�� ����
			int index = a.length + i;
			tmp[index] = b[i];
		}

		return tmp;
	}
	public static void print(int[] a) { // �迭 a ���
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
}

public class StaticEx {
	public static void main(String [] args){
		int [] array1 = { 1, 5, 7, 9 };
		int [] array2 = { 3, 6, -1, 100, 77 };
		int [] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}
}