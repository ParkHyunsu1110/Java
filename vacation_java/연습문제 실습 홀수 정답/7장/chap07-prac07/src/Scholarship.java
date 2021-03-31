import java.util.*;

class Scholarship {
	private String title;
	private Scanner scanner = new Scanner(System.in);
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	
	public Scholarship(String name) {
		this.title = name;
	}
	public void read() {
		System.out.println(title + "�����ý����Դϴ�.");
		for(int i=0; i<5; i++) {
			System.out.print("�̸��� ����>> ");
			String name = scanner.next();
			double score = scanner.nextDouble();
			scoreMap.put(name,  score);
		}		
	}
	
	public void select() {
		System.out.print("���л� ���� ���� ���� �Է�>> ");
		double cutline = scanner.nextDouble();
		
		System.out.print("���л� ��� : ");
		Set<String> nameSet = scoreMap.keySet();
		Iterator<String> it = nameSet.iterator();
		while(it.hasNext()) {
			String name = it.next();
			double score = scoreMap.get(name);
			if(score > cutline)
				System.out.print(name + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		Scholarship sship = new Scholarship("�̷����б�");
		sship.read();
		sship.select();
	}
}
