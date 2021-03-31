import java.util.Scanner;
import java.util.Vector;

public class CapitalGame {
	private Vector<Nation> store = new Vector<Nation>();
	private Scanner scanner = new Scanner(System.in);
	
	public CapitalGame() {
		// store�� 9 ���� �������� �Է��Ͽ� �ʱ�ȭ
		store.add(new Nation("�߽���", "�߽��ڽ�Ƽ"));
		store.add(new Nation("������", "������"));
		store.add(new Nation("������", "�ĸ�"));
		store.add(new Nation("����", "����"));
		store.add(new Nation("�׸���", "���׳�"));
		store.add(new Nation("����", "������"));
		store.add(new Nation("�Ϻ�", "����"));
		store.add(new Nation("�߱�", "������"));
		store.add(new Nation("���þ�", "��ũ��"));
	}
	
	private void error(String msg) {
		System.out.println(msg);
	}
	
	public void run() {
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		while(true) {
			System.out.print("�Է�:1, ����:2, ����:3>> ");
			int menu = scanner.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					error("�߸��� �Է��Դϴ�.");
			}
		}
		
	}

	private boolean contains(String country) {
		for(int i=0; i<store.size(); i++) {
			if(store.get(i).getCountry().equals(country)) { // ����ڰ� �Է��� ���� �̹� �ִٸ�
				return true;
			}
		}
		
		return false;

	}
	private void input() {
		int n = store.size();
		System.out.println("���� " + n + "�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		n++;
		while(true) {
			System.out.print("����� ���� �Է�" + n + ">> ");
			String country = scanner.next(); // ����� �Է� ����
			if(country.equals("�׸�")) {
				break;
			}
			String capital = scanner.next(); // ����� �Է�, ����

			if(contains(country)) { // ����ڰ� �Է��� ���� �̹� �ִٸ�
				System.out.println(country + "�� �̹� �ֽ��ϴ�!");
				continue;
			}
				
			store.add(new Nation(country, capital));
			n++;
		}
	}

	private void quiz() {
		// ��� Ű(����)�� �˾Ƴ���.
		while(true) {
			// ���� �߿��� �ϳ��� �����Ѵ�.
			int index = (int)(Math.random()*store.size()); // ������ ��ġ ����
			
			// ����(����)�� ����(����)�� �����Ѵ�.
			Nation nation = store.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
			// ������ ����Ѵ�.
			System.out.print(question + "�� ������? ");
			
			String capitalFromUser = scanner.next(); // ������� �Է�
			if(capitalFromUser.equals("�׸�")) {
				break;
			}
			if(capitalFromUser.equals(answer))
				System.out.println("����!!");
			else
				System.out.println("�ƴմϴ�!!");				
		}	
		
	}

	private void finish() {
		System.out.println("������ �����մϴ�.");	
	}

	public static void main(String[] args) {
		CapitalGame game = new CapitalGame();
		game.run();

	}

}
