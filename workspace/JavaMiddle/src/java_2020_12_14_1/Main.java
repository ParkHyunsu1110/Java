package java_2020_12_14_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] hangman = new String[10];

		int j = 0;

		Random random = new Random();
		int num = random.nextInt(hangman.length);

		int oppertunity = 5;
		boolean chance = true;
		for (int i = 0; i < hangman.length; i++) {
			System.out.print("������ ������ " + (i + 1) + "��° ���� �ܾ �Է��ϼ��� : ");
			String word = sc.next();
			hangman[i] = word;
		}

		String[] correct = new String[hangman[num].length()];
		String[] wrong = { " ", " ", " ", " ", " " };

		for (int i = 0; i < hangman[num].length(); i++) {
			correct[i] = "_ ";
		}

		while (chance) {
			
			System.out.println("---------------------------------");

			System.out.println("���� ��ȸ : " + oppertunity);

			System.out.println("������� �Էµ� �ܾ�");
			for (int i = 0; i < wrong.length; i++)
				System.out.print(wrong[i] + " ");
			System.out.println();

			System.out.println("���� �ܾ�");
			for (int i = 0; i < hangman[num].length(); i++) {
				System.out.print(correct[i]);
			}

			System.out.println();
			System.out.print("���ڸ� �Է��ϼ��� : ");
			String word2 = sc.next();

			String[] array = hangman[num].split("");

			boolean right = false;
			for (int i = 0; i < array.length; i++) {
				if (word2.equals(array[i])) {
					correct[i] = word2;
					right = true;
					continue;
				} else if (!word2.equals(hangman[num])) {

				}
			}
			if (right == false) {
				wrong[j] = word2;
				oppertunity--;
				j++;
			}
			boolean end = true;
			for ( int i = 0; i < correct.length; i++ ) {
				if ( correct[i].equals( "_ " ) ) end = false;
			}

			if ( end ) {
				System.out.println("��");
				break;
			}
			if (oppertunity == 0) {
				System.out.println("��ȸ�� �����Ǿ����ϴ٤Ф�");
				System.out.println("���� : " + hangman[num]);
				chance = false;
			}
			
		}
	}
}

