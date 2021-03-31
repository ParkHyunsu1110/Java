package Chapter4_Practice;
import java.util.Scanner;
/*
 * ���α׷��� : ������ �ܼ�Ʈ ���� �ý���
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
		System.out.print("�¼� ���� S(1), A(2), B(3)>>");
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
		System.out.print("�̸�>>");
		String name = sc.next();
		System.out.println();
		while(true){
			System.out.print("��ȣ>>");
			int sitNumber = sc.nextInt();
			sitNumber--;
			if(seat[sitNumber].equals("---")) {
				seat[sitNumber] = name;
				break;
			} else {
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
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
		System.out.println("<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>");
	}
	public  void cancel() {
		System.out.print("�¼� ���� S(1), A(2), B(3)>>"); int sitSelect = sc.nextInt();
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
			default: System.out.println("����� �¼��� Ÿ���� �ٽ� �Է��� �ּ���.");
		}
	}
	public static void eachLine(String seat[]) {
		for(int i=0; i<seat.length; i++)
			System.out.print(" " + seat[i] + " ");
		System.out.println();
	}
	public static void delete(String seat[]) {
		System.out.print("�̸�>>");
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
		System.out.println("��ǰ �ܼ�ƮȦ ���� �ý����Դϴ�.");
		while(true) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
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
				default: System.out.println("�ٽ� �Է��� �ּ���.");
			}
		}
	}

}
