package Chapter3_Practice;
/*
 * 프로그램명 : 정수 10개 저장하는 배열 만들고, 1~10까지의 정수 랜덤으로 저장하기, 배열안의 숫자와 평균 구하기
 * */
public class Q07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = new int[10];
		for(int i=0; i<n.length; i++) n[i] = (int)(Math.random()*10 + 1);
		int sum = 0;
		System.out.print("랜덤한 정수들 : ");
		for(int i = 0; i<n.length; i++) {
			System.out.print(n[i] + " ");
			sum += n[i];
		}
		System.out.println();
		System.out.println("평균은 " + (double)sum/n.length);
	}
}