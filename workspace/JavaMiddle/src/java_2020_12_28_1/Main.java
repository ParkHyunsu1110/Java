package java_2020_12_28_1;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int num = random.nextInt(100)+1;	//1~100������ ���� ����
		int times = 6;
		System.out.println("���ڰ� �����Ǿ����ϴ�.");
		while(true){
			System.out.println("���� ���� Ƚ�� : " + times + "\n------------------------------");
			System.out.print("���ڸ� �Է��� �ּ��� : ");
			int upDownNum = sc.nextInt();
			times--;
			if(times<=0) {
				System.out.println("��ȸ�� ��� �����Ǿ����ϴ�...");
				System.out.println("������ " + num + "�̾����ϴ�!");
				return;
			}
			if(upDownNum == num) { System.out.println("����!!"); return; }
			if(upDownNum > num) { System.out.println("Down");}
			if(upDownNum < num) { System.out.println("Up");}
			
		}
	}
}
