import java.util.*;

public class WordCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String s = scanner.nextLine();
			if(s.equals("�׸�")) {
				System.out.println("�����մϴ�...");	
				break;
			}
			StringTokenizer st = new StringTokenizer(s, " ");	
			System.out.println("���� ������ " + st.countTokens());
		}
		
		scanner.close();
	}
}
