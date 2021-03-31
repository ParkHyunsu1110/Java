package java_2020_10_09_3;
import java.util.*;
public class arrayList_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<>();	
		for(int i=0; i<5; i++) {
			System.out.print("수 입력 : ");
			int number = scanner.nextInt();
			arrayList.add(number);
		}
		System.out.println("현재 arrayList 내부 : ");
		System.out.print("[");
		for(int i=0; i<5; i++) {
			System.out.print(arrayList.get(i));
			if(i != 4) System.out.print(",");
			else System.out.println("]");
		}		
	}
}
