package java_2020_10_12_1;
import java.util.*;
public class vector_2 {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<>();
		Scanner sc = new Scanner(System.in);
		String word;
		for(int i=0; i<5; i++) {
			System.out.print("�Է� >> ");
			word = sc.next();
			vector.add(word);
		}
		for(int i=0; i<vector.size(); i++)
			System.out.println("�Է� ��� : " + vector.get(i));
	}
}
