package Chapter3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
 * 프로그램명 : 카드 번호 맞추기 게임(0~99)
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
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");
			while(true) {
				System.out.println(low + "-" + high);
				System.out.print((i+1) + ">>");
				int n=0;
				try {
					n = scanner.nextInt();
				}catch(InputMismatchException e){
					System.out.println("정수만 입력하셔야 합니다.");
					scanner.nextLine();
					continue;
				}
				if(n>high || n<low) System.out.println("범위를 벗어났어요.....");
				else {
					if(n == card) {
						System.out.println("맞았습니다!!");
						break;
					}
					else if(n>card) {
						System.out.println("더 낮게!!");
						high = n;
					}
					else {
						System.out.println("더 높게!!");
						low = n;
					}
				}
				i++;
			}
			System.out.println("다시 하시겠습니까??(y/n)>>");
			if(scanner.next().equals("n"))
				break;
		}
		scanner.close();
	}
}
