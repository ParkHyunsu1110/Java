package Chapter2_Practice;
/*
 * ���α׷��� : �ݾ� �� �ʿ� ���� ����
 * */
import java.util.Scanner;
public class Q03 {
	final static int ������ = 50000; 
	final static int ���� = 10000;
	final static int ��õ�� = 5000;
	final static int õ�� = 1000;
	final static int ����� = 500;
	final static int ��� = 100;
	final static int ���ʿ� = 50;
	final static int �ʿ� = 10;
	final static int �Ͽ� = 1;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��Ͻÿ�.>>"); int res, money = scanner.nextInt();
		res = money / ������;
		money = money % ������;
		if(res > 0) System.out.println("�������� " + res + "��");
		
		res = money / ����;
		money = money % ����;
		if(res > 0) System.out.println("������ " + res + "��");
		
		res = money / ��õ��;
		money = money % ��õ��;
		if(res > 0) System.out.println("��õ���� " + res + "��");
		
		res = money / õ��;
		money = money % õ��;
		if(res > 0) System.out.println("õ���� " + res + "��");
		
		res = money / �����;
		money = money % �����;
		if(res > 0) System.out.println("����� " + res + "��");
		
		res = money / ���;
		money = money % ���;
		if(res > 0) System.out.println("��� " + res + "��");
		
		res = money / ���ʿ�;
		money = money % ���ʿ�;
		if(res > 0) System.out.println("���ʿ� " + res + "��");
		
		res = money / �ʿ�;
		money = money % �ʿ�;
		if(res > 0) System.out.println("�ʿ� " + res + "��");
		
		res = money / �Ͽ�;
		money = money % �Ͽ�;
		if(res > 0) System.out.println("�Ͽ� " + res + "��");
	}
}
