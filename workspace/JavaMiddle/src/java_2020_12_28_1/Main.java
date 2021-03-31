package java_2020_12_28_1;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int num = random.nextInt(100)+1;	//1~100까지의 랜덤 숫자
		int times = 6;
		System.out.println("숫자가 결정되었습니다.");
		while(true){
			System.out.println("현재 남은 횟수 : " + times + "\n------------------------------");
			System.out.print("숫자를 입력해 주세요 : ");
			int upDownNum = sc.nextInt();
			times--;
			if(times<=0) {
				System.out.println("기회가 모두 소진되었습니다...");
				System.out.println("정답은 " + num + "이었습니다!");
				return;
			}
			if(upDownNum == num) { System.out.println("정답!!"); return; }
			if(upDownNum > num) { System.out.println("Down");}
			if(upDownNum < num) { System.out.println("Up");}
			
		}
	}
}
