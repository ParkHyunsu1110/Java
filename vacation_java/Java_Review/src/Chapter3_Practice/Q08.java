package Chapter3_Practice;

import java.util.Scanner;

/*
 * ���α׷��� : ���� ���� ���� �Է� �޾�(100�� �̸�) ���� �迭 ����, 1~100���� ���� ���� ����, ���� �� ���� �ϰ�, �迭 ����ϱ�
 * */
public class Q08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �? >>");
		int n = scanner.nextInt();
		int array[] = new int[n];
		
		int i = 0, tmp = 0, flag = 0;
		/* i=�迭�ȿ� ����� ������ ����, tmp=�������� ���� ���� �ӽ� �����ϴ� ����, flag=�迭�ȿ� �ִ� ���ڰ� �������� �����ϴ� �Լ� */
		while(i <= n-1) {
			tmp = (int)(Math.random() * 100 + 1);	//���� ���� ����
			for(int j = 0; j < i; j++) {//���� �迭�ȿ� �ִ� ���ڵ� �߿��� �������� ������� ������ ���� ���� �ִ��� Ȯ����.
				if(tmp == array[j]) {
					flag = 1;
					break;				//���� ���� ���� ������ flag�� 1�� �ʱ�ȭ ���� �ݺ��� ����.
				}
				else
					flag = 0;			//������ flag 0���� �ʱ�ȭ
			}
			if(flag == 1)
				continue;		//flag�� 1�̸� �������� �ٽ� ������ �ϱ⿡ continue
			else {
				array[i] = tmp;			//flag�� 0�̸� ���� ���� �����Ƿ� �迭�� �����ϰ�, j�� �÷���
				i++;
			}
		}
		int count = 1;	//10���� �� �ٷ� ����ϱ� ���� ���� ����
		for(i = 0; i < n; i++) {	//�迭�� ũ�⸸ŭ �ݺ�
			System.out.print(array[i] + " ");	//�迭 �� ����ϱ�
			count++;	//ī��Ʈ ����
			if(count == 11) {	//10�� ����ϰ� �� �Ŀ��� �� �� ���� �ٽ� count�� 1�� �ʱ�ȭ
				System.out.println();
				count=1;
			}
		}
		scanner.close();
	}

}
