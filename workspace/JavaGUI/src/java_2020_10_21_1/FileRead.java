package java_2020_10_21_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class FileRead {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		File file = new File("data/information");
		
		System.out.print("id : ");
		String userId = scanner.next();
		System.out.print("pw : ");
		String userPw = scanner.next();
		
		boolean loginSuccess = false;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String id_infor = sc.next();
			String pw_infor = sc.next();
			String name_infor = sc.next();
			int age_infor = sc.nextInt();
			
			if(userId.equals(id_infor) && userPw.equals(pw_infor)) {
				loginSuccess = true;
			}
		}
		if( loginSuccess == true ) System.out.println(userId + "님 환영합니다.");
		else System.out.println("로그인에 실패하셨습니다.");
		
	}
}
