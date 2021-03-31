package java_2020_12_28_2;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---당첨자 뽑기---");
		System.out.print("인원수 : ");
		int headCount = sc.nextInt();
		
		ArrayList<String> Names = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i=0; i<headCount; i++) {	//이름 입력
			System.out.print("사용자 이름 : "); String userName = sc.next();
			Names.add(userName);
		}
		
		System.out.print("당첨자 수 : "); int Winning = sc.nextInt();
		for(int i=0; i<headCount; i++) {	//꽝, 당첨 조절
			if(i<Winning) result.add("당첨!");
			else result.add("꽝ㅠ");
		}
		Collections.shuffle(result);	//결과 섞기
		
		while(true) {	//제비뽑기 진행
			System.out.println("--------------------\n1. 각자 결과 확인하기.\n2. 전체 결과 확인하기.\n3. 그만하기.");
			System.out.print("선택할 번호 : ");
			int number = sc.nextInt();
			int nameIndex=0;
			if(number == 1) {
				System.out.println("각자의 결과를 확인합니다.");
				System.out.print("이름을 입력해 주세요. : ");
				String name = sc.next();
				for(int i=0; i<Names.size(); i++) {
					if(name.equals(Names.get(i))) nameIndex = i;
				}
				System.out.println(name + "의 결과는 " + result.get(nameIndex));
			} else if(number == 2) {
				System.out.println("전체 결과를 확인합니다.");
				for(int i=0; i<Names.size(); i++) {
					System.out.println(Names.get(i) + "의 결과 : " + result.get(i));
				}
			} else if(number == 3) {
				System.out.println("제비뽑기를 종료합니다.");
				return;
			}
		}	
	}
}
