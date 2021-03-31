package java_2020_10_09_3;

import java.util.*;

public class arrayList_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> arrayList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			String word = scanner.next();
			arrayList.add(word);
		}
		for(int i=0; i<arrayList.size(); i++) {
			System.out.print(arrayList.get(i));
			if( i != (arrayList.size())) System.out.print(" ");
		}
	}

}
