package Chapter3_Practice;
/*
 * ���α׷��� : ���� 10�� �����ϴ� �迭 �����, 1~10������ ���� �������� �����ϱ�, �迭���� ���ڿ� ��� ���ϱ�
 * */
public class Q07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = new int[10];
		for(int i=0; i<n.length; i++) n[i] = (int)(Math.random()*10 + 1);
		int sum = 0;
		System.out.print("������ ������ : ");
		for(int i = 0; i<n.length; i++) {
			System.out.print(n[i] + " ");
			sum += n[i];
		}
		System.out.println();
		System.out.println("����� " + (double)sum/n.length);
	}
}