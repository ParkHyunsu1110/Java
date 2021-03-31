package Chapter3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
 * ���α׷��� : ī�� ��ȣ ���߱� ����(0~99)
 * */
public class Open_Challenge_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int low, high, card;
		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		
		while(true) {
			int i=0;
			low=0; high=99;
			card = r.nextInt(100);
			System.out.println("���� �����Ͽ����ϴ�. ���߾� ������.");
			while(true) {
				System.out.println(low + "-" + high);
				System.out.print((i+1) + ">>");
				int n=0;
				try {
					n = scanner.nextInt();
				}catch(InputMismatchException e){
					System.out.println("������ �Է��ϼž� �մϴ�.");
					scanner.nextLine();
					continue;
				}
				if(n>high || n<low) System.out.println("������ ������.....");
				else {
					if(n == card) {
						System.out.println("�¾ҽ��ϴ�!!");
						break;
					}
					else if(n>card) {
						System.out.println("�� ����!!");
						high = n;
					}
					else {
						System.out.println("�� ����!!");
						low = n;
					}
				}
				i++;
			}
			System.out.println("�ٽ� �Ͻðڽ��ϱ�??(y/n)>>");
			if(scanner.next().equals("n"))
				break;
		}
		scanner.close();
	}
}
