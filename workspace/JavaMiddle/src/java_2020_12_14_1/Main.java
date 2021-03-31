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
			System.out.print("문제로 출제할 " + (i + 1) + "번째 영어 단어를 입력하세요 : ");
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

			System.out.println("남은 기회 : " + oppertunity);

			System.out.println("현재까지 입력된 단어");
			for (int i = 0; i < wrong.length; i++)
				System.out.print(wrong[i] + " ");
			System.out.println();

			System.out.println("남은 단어");
			for (int i = 0; i < hangman[num].length(); i++) {
				System.out.print(correct[i]);
			}

			System.out.println();
			System.out.print("글자를 입력하세요 : ");
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
				System.out.println("끝");
				break;
			}
			if (oppertunity == 0) {
				System.out.println("기회가 소진되었습니다ㅠㅠ");
				System.out.println("정답 : " + hangman[num]);
				chance = false;
			}
			
		}
	}
}

