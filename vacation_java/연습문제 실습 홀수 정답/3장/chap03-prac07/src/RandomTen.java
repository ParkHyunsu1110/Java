
public class RandomTen {

	public static void main(String[] args) {
		int n [] = new int [10]; // �迭 ����
		
		for(int i=0; i<n.length; i++) { // 10���� ������ ���� ���� �� ����
			int r = (int)(Math.random()*10 + 1);
			n[i] = r;
		}
		
		int sum = 0;
		for(int i=0; i<n.length; i++) // �� ���ϱ�
			sum += n[i];
		
		System.out.print("������ ������ : ");
		for(int i=0; i<n.length; i++)
			System.out.print(n[i] +" ");
		
		System.out.println("\n����� " + (double)sum/n.length);
	}

}
