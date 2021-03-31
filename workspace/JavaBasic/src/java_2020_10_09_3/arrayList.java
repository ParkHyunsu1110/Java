package java_2020_10_09_3;
import java.util.ArrayList;
import java.util.List;
public class arrayList {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		//ArrayList<Integer> arrayList2 = new ArrayList<>();
		
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(6);
		
		for(int i : arrayList) System.out.println(i);
		
//		List<Integer> list = arrayList.subList(1, 3);
//		
//		for(int i:arrayList) System.out.println("arrayList : "+i);
//		
//		System.out.println("--------------------");
//		
//		for(int i=0; i<list.size(); i++) System.out.println("subList 메소드로 가져온 List : " + list.get(i));
		
		//System.out.println( arrayList.get(2));
		
//		arrayList2.add(10);
//		arrayList2.add(20);
//		arrayList2.add(30);
//		arrayList.addAll(arrayList2); 
//		arrayList.remove(2);
//	
//		for(int i=0; i<arrayList.size(); i++) System.out.println("arrayList 값 : " + arrayList.get(i));
	}
}
