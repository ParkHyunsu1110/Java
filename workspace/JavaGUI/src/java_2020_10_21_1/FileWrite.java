package java_2020_10_21_1;
import java.io.*;
import java.util.*;
public class FileWrite {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("id : ");
		String id = scanner.next();
		System.out.print("pw : ");
		String pw = scanner.next();
		System.out.print("name : ");
		String name = scanner.next();
		System.out.print("age : ");
		int age = scanner.nextInt();
		
		File file = new File("data/information");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(id + " " + pw + " " + name + " " + age + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
