package java_2020_12_09_1;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		Random random = new Random();
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������ �������ϴ�.");
			}
		};
		
		String[] sW = { "apple", "banana", "cat", "time", "egg", "game", "zoo" };	//�ʱ� �ܾ��
		int num = random.nextInt(sW.length);	//sW���̸�ŭ�� ���� ���� �̱�
		String word = sW[num];					//word�� sW�� ���� ��ȣ �ܾ�
		System.out.print("���� ���� �ð� : ");		
		int time = scanner.nextInt();	//�� �Է�
		System.out.println(time + "�� ���� ������ ����˴ϴ�.");
		System.out.println("ù���� �ܾ�� "+word+"�Դϴ�.");
		
		Scanner sc = new Scanner(System.in);
		timer.schedule(task, time * 1000);
		while(true) {
			int lastIndex = word.length()-1;	//���� �ܾ� ������ ������ �ε���
			char lastChar = word.charAt(lastIndex);	//������ ����
			String nWord = sc.next();
			if(lastChar == nWord.charAt(0)) {	//������ ���ڶ� �Է� �ܾ� ù���ڶ� ������.
				word = nWord;
				System.out.println(word);
			}else {
				System.out.println("�ùٸ��� �ʽ��ϴ�!! �ٽ� �Է��� �ּ���.");
				continue;
			}
		}
	}
}
