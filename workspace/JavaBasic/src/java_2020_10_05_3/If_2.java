package java_2020_10_05_3;
import java.util.Scanner;
public class If_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scanner.next();
		
		if(name.equals("ȫ�浿")) System.out.println("����");
		
		else if(name.equals("������")) System.out.println("����");
		
		else System.out.println("�𸣰ھ��.");
	}
}
