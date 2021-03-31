package java_2020_10_12_1;

import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vector = new Vector<>();
		
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		vector.addElement(2);
		//vector.remove(1);
		System.out.println(vector);
		System.out.println(vector.get(4));
		System.out.println(vector.size());
		vector.clear();
		System.out.println(vector);
	}
}
