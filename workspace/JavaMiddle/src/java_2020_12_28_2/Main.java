package java_2020_12_28_2;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---��÷�� �̱�---");
		System.out.print("�ο��� : ");
		int headCount = sc.nextInt();
		
		ArrayList<String> Names = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i=0; i<headCount; i++) {	//�̸� �Է�
			System.out.print("����� �̸� : "); String userName = sc.next();
			Names.add(userName);
		}
		
		System.out.print("��÷�� �� : "); int Winning = sc.nextInt();
		for(int i=0; i<headCount; i++) {	//��, ��÷ ����
			if(i<Winning) result.add("��÷!");
			else result.add("�Τ�");
		}
		Collections.shuffle(result);	//��� ����
		
		while(true) {	//����̱� ����
			System.out.println("--------------------\n1. ���� ��� Ȯ���ϱ�.\n2. ��ü ��� Ȯ���ϱ�.\n3. �׸��ϱ�.");
			System.out.print("������ ��ȣ : ");
			int number = sc.nextInt();
			int nameIndex=0;
			if(number == 1) {
				System.out.println("������ ����� Ȯ���մϴ�.");
				System.out.print("�̸��� �Է��� �ּ���. : ");
				String name = sc.next();
				for(int i=0; i<Names.size(); i++) {
					if(name.equals(Names.get(i))) nameIndex = i;
				}
				System.out.println(name + "�� ����� " + result.get(nameIndex));
			} else if(number == 2) {
				System.out.println("��ü ����� Ȯ���մϴ�.");
				for(int i=0; i<Names.size(); i++) {
					System.out.println(Names.get(i) + "�� ��� : " + result.get(i));
				}
			} else if(number == 3) {
				System.out.println("����̱⸦ �����մϴ�.");
				return;
			}
		}	
	}
}
