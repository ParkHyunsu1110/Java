package Chapter2;

import java.util.Scanner;

public class E_Time_Transform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���.");
		int time = scanner.nextInt();
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = (time / 60) / 60;
		
		System.out.println(time + "�ʴ�" + hour + "�ð�" + minute + "��" + second + "�� �Դϴ�.");
		scanner.close();
	}

}
