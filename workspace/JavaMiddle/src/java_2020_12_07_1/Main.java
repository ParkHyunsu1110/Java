package java_2020_12_07_1;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("마방진의 크기(단, 2와 100 사이의 홀수) : ");
		int s = scanner.nextInt(); 			//크기 입력
		if(s%2 == 0) {
			System.out.println("홀수를 입력하지 않아 종료됩니다.");
			return;
		}
		//변수 생성
		int[][] ms = new int[s][s];				//s*s 크기의 2차원 배열 생성
		int a = 1;
		int row = 0, colum = s/2;				//마방진의 가로세로 크기 지정, colum 값을 중앙으로 배치		
		//내용
		for(a=1; a<=(s*s); a++) {
			ms[row][colum] = a;					//첫번째 수
			if(a % s == 0) row++;				//숫자가 끝에 닿았음 ->아랫줄로 내림
			else {
				row--;							//윗줄로 올림
				colum--;						//왼쪽으로 이동
				if(row<0) row = s-1;			//행이 0이하이면 크기 - 1 해주기
				else if(colum<0) colum = s-1;	//열이 0이하이면 크기 - 1
			}
		}
		//출력
		for(int i=0; i<ms.length; i++) {
			for(int j=0; j<ms[i].length; j++) {
				System.out.print(ms[i][j] + "	");
			}
			System.out.println("");
		}		
	}
}
