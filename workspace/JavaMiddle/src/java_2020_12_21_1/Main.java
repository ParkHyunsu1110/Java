package java_2020_12_21_1;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		String[] words = { "chair", "cat", "cake", "sea", "rule", "you", "black", "way", "live", "pain", "site", 
				"yes", "table", "sick", "dog", "angle", "corn", "raise", "chain", "can", "class" };	//단어 배열 선언
		int num = random.nextInt(words.length);	//words 범위의 무작위 난수 선언
		String question = words[num];
		System.out.println("영단어 야구게임을 시작합니다. 영단어에는 같은 알파벳이 들어가서는 안 된다는걸 유의해둔 후, 진행해 주세요.");
		
		String[] word = new String[question.length()];	//맞춰야할 단어 길이 설정
		for(int i=0; i<question.length(); i++)  word[i] = "_ "; //입력할 단어에 "_" 넣기
		for(String inner : word) System.out.print(inner);			//"_ "출력
		
		System.out.println(question);	//테스트
		
		int oppertunity = question.length() + 5;	//게임 기회
		int times=0;	//반복문 실행 횟수
		boolean doWhile = true;	//반복 제어
		
		String[] correct = question.split("");
		int s=0, b=0;
		while(doWhile) {
			times++;	//게임 진행 횟수
			String answer = sc.next();	//단어 입력
			String[] array = answer.split("");	//단어 분할
			if(answer.length() != correct.length) {		//입력 글자의 길이가 정답 단어의 길이와 가르다면 경고 이후 반복문 재실행
				System.out.println("글자수를 맞게 해주세요.");
				oppertunity--;
			}else {
				for(int i=0; i<correct.length; i++) {	//반복 시작
					if(array[i].equals(correct[i])) s++;	//만약 입력 단어의 i번쨰가 정답 단어의 i번째와 같다면 s++
					else if(question.contains(array[i])) b++;	//만약 입력단어가 정답 단어의 i번째에 있다면 b++
				}
				
				System.out.println(s + "s    " + b + "b");	//같은 위치 단어, 존재 단어 갯수 출력
			}

			if(s == question.length()) System.out.println(times + "번만에 정답을 맞추셨습니다!!"); 			//성공
			if(oppertunity < 1) {
				System.out.println("안타깝습니다.\n정답은 " + question +"이었습니다.");	//실패
				doWhile = false;
			}
			s=0; b=0;	//s 초기화, b 초기화
		}
	}
}
