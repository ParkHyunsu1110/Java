package Chapter2;

import java.util.Scanner;

public class E_Time_Transform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요.");
		int time = scanner.nextInt();
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = (time / 60) / 60;
		
		System.out.println(time + "초는" + hour + "시간" + minute + "분" + second + "초 입니다.");
		scanner.close();
	}

}
