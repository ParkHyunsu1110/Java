package Chapter3_Practice;

import java.util.Scanner;

/*
 * 프로그램명 : 정수 저장 갯수 입력 받아(100개 미만) 정수 배열 생성, 1~100까지 정수 랜덤 삽입, 같은 수 없게 하고, 배열 출력하기
 * */
public class Q08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 몇개? >>");
		int n = scanner.nextInt();
		int array[] = new int[n];
		
		int i = 0, tmp = 0, flag = 0;
		/* i=배열안에 저장된 숫자의 갯수, tmp=랜덤으로 만든 수를 임시 저장하는 변수, flag=배열안에 있는 숫자가 랜덤으로 저장하는 함수 */
		while(i <= n-1) {
			tmp = (int)(Math.random() * 100 + 1);	//랜덤 변수 생성
			for(int j = 0; j < i; j++) {//현재 배열안에 있는 숫자들 중에서 랜덤으로 만들어진 변수와 같은 수가 있는지 확인함.
				if(tmp == array[j]) {
					flag = 1;
					break;				//만약 같은 수가 있으면 flag를 1로 초기화 한후 반복문 멈춤.
				}
				else
					flag = 0;			//없으면 flag 0으로 초기화
			}
			if(flag == 1)
				continue;		//flag가 1이면 랜덤수를 다시 만들어야 하기에 continue
			else {
				array[i] = tmp;			//flag가 0이면 같은 수가 없으므로 배열에 저장하고, j를 올려줌
				i++;
			}
		}
		int count = 1;	//10개씩 한 줄로 출력하기 위헤 만든 변수
		for(i = 0; i < n; i++) {	//배열의 크기만큼 반복
			System.out.print(array[i] + " ");	//배열 수 출력하기
			count++;	//카운트 세기
			if(count == 11) {	//10개 출력하고 난 후에는 한 줄 띄우고 다시 count를 1로 초기화
				System.out.println();
				count=1;
			}
		}
		scanner.close();
	}

}
