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
				System.out.println("게임이 끝났습니다.");
			}
		};
		
		String[] sW = { "apple", "banana", "cat", "time", "egg", "game", "zoo" };	//초기 단어들
		int num = random.nextInt(sW.length);	//sW길이만큼의 랜덤 숫자 뽑기
		String word = sW[num];					//word는 sW의 랜덤 번호 단어
		System.out.print("게임 진행 시간 : ");		
		int time = scanner.nextInt();	//초 입력
		System.out.println(time + "초 동안 게임이 진행됩니다.");
		System.out.println("첫번쨰 단어는 "+word+"입니다.");
		
		Scanner sc = new Scanner(System.in);
		timer.schedule(task, time * 1000);
		while(true) {
			int lastIndex = word.length()-1;	//직전 단어 마지막 글자의 인덱스
			char lastChar = word.charAt(lastIndex);	//마지막 문자
			String nWord = sc.next();
			if(lastChar == nWord.charAt(0)) {	//마지막 문자랑 입력 단어 첫들자랑 같은지.
				word = nWord;
				System.out.println(word);
			}else {
				System.out.println("올바르지 않습니다!! 다시 입력해 주세요.");
				continue;
			}
		}
	}
}
