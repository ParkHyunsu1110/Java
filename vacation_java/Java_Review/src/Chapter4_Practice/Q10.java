package Chapter4_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : Dictionary
 * */
class Dictionary {
	private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
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
		System.out.println("한영 단어 검색 프로그램입니다.");
		while(true) {
			System.out.print("한글단어?>>"); String kor=scanner.next();
			if(kor.equals("그만")) break;
			String eng = Dictionary.kor2Eng(kor);
			if(eng==null) System.out.println(kor + "은 저의 사전에 없습니다.");
			else System.out.println(kor + "은 " + eng);
		}
	}

}
