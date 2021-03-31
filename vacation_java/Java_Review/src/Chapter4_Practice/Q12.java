package Chapter4_Practice;
import java.util.Scanner;
/*
 * 프로그램명 : 간단한 콘서트 예약 시스템
 * */
class Concert{
	 
	private String [] S;
	private String [] A;
	private String [] B;
	private static Scanner sc;
	Concert() {
		sc = new Scanner(System.in);
		S  = new String[10];
		A  = new String[10];
		B  = new String[10];
		for(int i=0; i<S.length; i++) {
			S[i] = "---";
			A[i] = "---";
			B[i] = "---";
		}
	}
	public void reservation() {
		System.out.print("좌석 구분 S(1), A(2), B(3)>>");
		int sitSelect = sc.nextInt();
		switch(sitSelect) {
			case 1: 
				System.out.print("S>>");
				eachLine(S);
				insert(S);
				return;
			case 2:
				System.out.print("A>>");
				eachLine(A);
				insert(A);
				return;
			case 3:
				System.out.print("B>>");
				eachLine(B);
				insert(B);
				return;
			default: System.out.println();
		}
	}
	public static void insert(String seat[]) {
		System.out.print("이름>>");
		String name = sc.next();
		System.out.println();
		while(true){
			System.out.print("번호>>");
			int sitNumber = sc.nextInt();
			sitNumber--;
			if(seat[sitNumber].equals("---")) {
				seat[sitNumber] = name;
				break;
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}
	public void inquiry() {
		System.out.print("S>>");
		Concert.eachLine(S);
		System.out.print("A>>");
		Concert.eachLine(A);
		System.out.print("B>>");
		Concert.eachLine(B);
		System.out.println("<<조회를 완료하였습니다.>>");
	}
	public  void cancel() {
		System.out.print("좌석 구분 S(1), A(2), B(3)>>"); int sitSelect = sc.nextInt();
		switch(sitSelect) {
			case 1: 
				System.out.print("S>>");
				eachLine(S);
				delete(S);
				return;
			case 2:
				System.out.print("A>>");
				eachLine(A);
				delete(A);
				return;
			case 3:
				System.out.print("B>>");
				eachLine(B);
				delete(B);
				return;
			default: System.out.println("취소할 좌석의 타입을 다시 입력해 주세요.");
		}
	}
	public static void eachLine(String seat[]) {
		for(int i=0; i<seat.length; i++)
			System.out.print(" " + seat[i] + " ");
		System.out.println();
	}
	public static void delete(String seat[]) {
		System.out.print("이름>>");
		String name = sc.next();
		for(int i=0; i<seat.length; i++) {
			if(name.equals(seat[i])) {
				seat[i] = "---";
				break;
			}
		}
	}
}
public class Q12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("명품 콘서트홀 예약 시스템입니다.");
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			Concert con = new Concert();
			int choice = scanner.nextInt();
			switch(choice) {
				case 1:
					con.reservation();
					break;
				case 2:
					con.inquiry();
					break;
				case 3:
					con.cancel();
					break;
				case 4: break;
				default: System.out.println("다시 입력해 주세요.");
			}
		}
	}

}
