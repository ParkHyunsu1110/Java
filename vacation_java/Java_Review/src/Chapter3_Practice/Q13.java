package Chapter3_Practice;
/*
 * 프로그램명 : 반복문을 이용해 369게임 하기 1~99까지
 * */
public class Q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<100; i++) {
			if(i>=10) { //10보다 큰 수 (두자릿수)
				if(i/10==3||i/10==6||i/10==9) { //10의 자리가 3, 6, 9 일때
					if(i%10==3||i%10==6||i%10==9) System.out.println(i+" 박수 짝짝"); //1의 자리도 3, 6, 9 일때
					else System.out.println(i+ " 박수 짝"); //1의 자리는 3,6,9가 아닐 때
				}
				
				else if(i%10==3||i%10==6||i%10==9) System.out.println(i+" 박수 짝");
					//10의 자리가 3, 6, 9가 아닌데 1의 자리는 3, 6, 9 일 때
			}
			
			if(i<10)
				if(i%10==3||i%10==6||i%10==9) System.out.println(i+" 박수 짝"); //1의 자리만 3,6,9일 때
		}
	}

}
