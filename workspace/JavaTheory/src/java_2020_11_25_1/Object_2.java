package java_2020_11_25_1;

import java.util.ArrayList;

public class Object_2 {
	public static void main(String[] args) {
		ArrayList<Object> square = new ArrayList<>();
		square.add(2);
		square.add("1���簢��");
		square.add(4);
		square.add("2�� �簢��");
		square.add(7);
		square.add("3�� ���簢��");
		for( int i=0; i<square.size(); i+=2) {
			System.out.println(square.get(i+1) + " : " + (int)(square.get(i))*(int)(square.get(i)));
		}
	}
}
