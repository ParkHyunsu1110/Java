package Chapter4_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : Dictionary
 * */
class Dictionary {
	private static String [] kor = {"���", "�Ʊ�", "��", "�̷�", "���"};
	private static String [] Eng = {"love", "baby", "money", "future", "hope"};
	public static String kor2Eng(String word) {
		for(int i=0; i<kor.length; i++) {
			if(word.equals(kor[i]))
				return Eng[i];
		}
		return null;
	};
}
public class Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		while(true) {
			System.out.print("�ѱ۴ܾ�?>>"); String kor=scanner.next();
			if(kor.equals("�׸�")) break;
			String eng = Dictionary.kor2Eng(kor);
			if(eng==null) System.out.println(kor + "�� ���� ������ �����ϴ�.");
			else System.out.println(kor + "�� " + eng);
		}
	}

}
