package java_2020_12_07_1;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������� ũ��(��, 2�� 100 ������ Ȧ��) : ");
		int s = scanner.nextInt(); 			//ũ�� �Է�
		if(s%2 == 0) {
			System.out.println("Ȧ���� �Է����� �ʾ� ����˴ϴ�.");
			return;
		}
		//���� ����
		int[][] ms = new int[s][s];				//s*s ũ���� 2���� �迭 ����
		int a = 1;
		int row = 0, colum = s/2;				//�������� ���μ��� ũ�� ����, colum ���� �߾����� ��ġ		
		//����
		for(a=1; a<=(s*s); a++) {
			ms[row][colum] = a;					//ù��° ��
			if(a % s == 0) row++;				//���ڰ� ���� ����� ->�Ʒ��ٷ� ����
			else {
				row--;							//���ٷ� �ø�
				colum--;						//�������� �̵�
				if(row<0) row = s-1;			//���� 0�����̸� ũ�� - 1 ���ֱ�
				else if(colum<0) colum = s-1;	//���� 0�����̸� ũ�� - 1
			}
		}
		//���
		for(int i=0; i<ms.length; i++) {
			for(int j=0; j<ms[i].length; j++) {
				System.out.print(ms[i][j] + "	");
			}
			System.out.println("");
		}		
	}
}
