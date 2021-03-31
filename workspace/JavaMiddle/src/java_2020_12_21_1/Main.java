package java_2020_12_21_1;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		String[] words = { "chair", "cat", "cake", "sea", "rule", "you", "black", "way", "live", "pain", "site", 
				"yes", "table", "sick", "dog", "angle", "corn", "raise", "chain", "can", "class" };	//�ܾ� �迭 ����
		int num = random.nextInt(words.length);	//words ������ ������ ���� ����
		String question = words[num];
		System.out.println("���ܾ� �߱������� �����մϴ�. ���ܾ�� ���� ���ĺ��� ������ �� �ȴٴ°� �����ص� ��, ������ �ּ���.");
		
		String[] word = new String[question.length()];	//������� �ܾ� ���� ����
		for(int i=0; i<question.length(); i++)  word[i] = "_ "; //�Է��� �ܾ "_" �ֱ�
		for(String inner : word) System.out.print(inner);			//"_ "���
		
		System.out.println(question);	//�׽�Ʈ
		
		int oppertunity = question.length() + 5;	//���� ��ȸ
		int times=0;	//�ݺ��� ���� Ƚ��
		boolean doWhile = true;	//�ݺ� ����
		
		String[] correct = question.split("");
		int s=0, b=0;
		while(doWhile) {
			times++;	//���� ���� Ƚ��
			String answer = sc.next();	//�ܾ� �Է�
			String[] array = answer.split("");	//�ܾ� ����
			if(answer.length() != correct.length) {		//�Է� ������ ���̰� ���� �ܾ��� ���̿� �����ٸ� ��� ���� �ݺ��� �����
				System.out.println("���ڼ��� �°� ���ּ���.");
				oppertunity--;
			}else {
				for(int i=0; i<correct.length; i++) {	//�ݺ� ����
					if(array[i].equals(correct[i])) s++;	//���� �Է� �ܾ��� i������ ���� �ܾ��� i��°�� ���ٸ� s++
					else if(question.contains(array[i])) b++;	//���� �Է´ܾ ���� �ܾ��� i��°�� �ִٸ� b++
				}
				
				System.out.println(s + "s    " + b + "b");	//���� ��ġ �ܾ�, ���� �ܾ� ���� ���
			}

			if(s == question.length()) System.out.println(times + "������ ������ ���߼̽��ϴ�!!"); 			//����
			if(oppertunity < 1) {
				System.out.println("��Ÿ�����ϴ�.\n������ " + question +"�̾����ϴ�.");	//����
				doWhile = false;
			}
			s=0; b=0;	//s �ʱ�ȭ, b �ʱ�ȭ
		}
	}
}
