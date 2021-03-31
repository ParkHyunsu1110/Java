package Basic;
import java.util.ArrayList;
import java.util.Scanner;
public class ListMake {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> arrayList = new ArrayList<>();
		System.out.println("# i : 사용자에게 이름을 입력받아 arrayList에 넣으세요.\r\n" + 
		"# p : arrayList의 목록을 출력하세요.\r\n" + 
		"# d : 사용자에게 이름을 입력받아 해당하는 이름을 arrayList에서 삭제하세요.\r\n" + 
		"# x : 프로그램을 종료하세요.");
		while(true) {
			System.out.print("명령을 입력해 주세요. : ");
			String menu = scanner.next();
			switch(menu) {
				case "i":
					System.out.println("이름을 리스트에 추가합니다.");
					String inputList = scanner.next();
					arrayList.add(inputList);
					continue;
				case "p":
					System.out.println(arrayList);
					continue;
				case "d":
					System.out.print("입력한 단어를 삭제 합니다. : ");
					String deleteList = scanner.next();
					arrayList.remove(deleteList);
					continue;
				case "x":
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("올바른 명령어를 입력해 주세요.");
					continue;
			}
		}
	}
}
