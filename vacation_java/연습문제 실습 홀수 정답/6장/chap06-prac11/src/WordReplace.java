import java.util.Scanner;

public class WordReplace {

	public static void main(String[] args) {
		System.out.print(">>");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine(); // �� ������ ���ڿ��� �д´�.
		StringBuffer sb = new StringBuffer(text);
		
		while(true) {
			System.out.print("���: ");
			String cmd = scanner.nextLine(); // �� ������ ���ڿ��� �д´�.
			if(cmd.equals("�׸�")) {
				System.out.print("�����մϴ�");
				break;
			}
			String [] tokens = cmd.split("!");
			if(tokens.length != 2) {
				System.out.println("�߸��� ����Դϴ�!");
			}
			else {
				if(tokens[0].length() == 0 || tokens[1].length() == 0) {
					System.out.println("�߸��� ����Դϴ�!");
					continue;
				}
				
				int index = sb.indexOf(tokens[0]);
				if(index == -1) { // not found!
					System.out.println("ã�� �� �����ϴ�!");
					continue;
				}
				sb.replace(index, index+tokens[0].length(), tokens[1]);
				System.out.println(sb.toString());
			}
		}
		
		scanner.close();

	}

}
