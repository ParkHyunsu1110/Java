package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ���������� �ϱ�
 * */
public class Q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String str[] = {"����","����","��"};
		System.out.println("��ǻ�Ϳ� ���������� ������ �մϴ�.");
		
		while(true) {
			int c_rsp_n = 0;
			String c_rsp;
			
			System.out.print("���� ���� ��! >>"); String rsp = scanner.next();
			if(rsp.equals("�׸�")) { 
				System.out.println("������ �����մϴ�....");
				break;
			}else {
				c_rsp_n = (int)(Math.random()*3);
				c_rsp =str[c_rsp_n];
				
				if(c_rsp.equals("����") == true) {
					if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �����ϴ�.");
					else if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �̰���ϴ�.");
					else if(rsp.equals("��") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �����ϴ�.");
				}else if(c_rsp.equals("����") == true) {
					if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �����ϴ�.");
					else if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �����ϴ�.");
					else if(rsp.equals("��") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �̰���ϴ�.");
				} else if(c_rsp.equals("��") == true)  {
					if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �̰���ϴ�.");
					else if(rsp.equals("����") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", �����ϴ�.");
					else if(rsp.equals("��") == true) System.out.println("����� : " + rsp + ", ��ǻ�� : " + c_rsp + ", ����ϴ�.");
				}
				
			}
		}
		scanner.close();
	}
}
