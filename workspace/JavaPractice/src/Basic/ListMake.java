package Basic;
import java.util.ArrayList;
import java.util.Scanner;
public class ListMake {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> arrayList = new ArrayList<>();
		System.out.println("# i : ����ڿ��� �̸��� �Է¹޾� arrayList�� ��������.\r\n" + 
		"# p : arrayList�� ����� ����ϼ���.\r\n" + 
		"# d : ����ڿ��� �̸��� �Է¹޾� �ش��ϴ� �̸��� arrayList���� �����ϼ���.\r\n" + 
		"# x : ���α׷��� �����ϼ���.");
		while(true) {
			System.out.print("����� �Է��� �ּ���. : ");
			String menu = scanner.next();
			switch(menu) {
				case "i":
					System.out.println("�̸��� ����Ʈ�� �߰��մϴ�.");
					String inputList = scanner.next();
					arrayList.add(inputList);
					continue;
				case "p":
					System.out.println(arrayList);
					continue;
				case "d":
					System.out.print("�Է��� �ܾ ���� �մϴ�. : ");
					String deleteList = scanner.next();
					arrayList.remove(deleteList);
					continue;
				case "x":
					System.out.println("���α׷��� �����մϴ�.");
					return;
				default:
					System.out.println("�ùٸ� ��ɾ �Է��� �ּ���.");
					continue;
			}
		}
	}
}
