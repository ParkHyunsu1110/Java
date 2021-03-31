import java.util.*;

public class StudentManager {
	private Scanner scanner = new Scanner(System.in);
	private HashMap<String, Student> dept = new HashMap<String, Student>();
	
	private void read() {
		System.out.println("�л� �̸�,�а�,�й�,������� �Է��ϼ���.");
		for (int i=0; i<4; i++) {
			System.out.print(">> ");
			String text = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(text, ",");
			String name = st.nextToken().trim();
			String department = st.nextToken().trim();
			String id = st.nextToken().trim();
			double grade = Double.parseDouble(st.nextToken().trim());
			
			Student student = new Student(name, department, id, grade);
			dept.put(name, student); //�ؽøʿ� ����
		}			
	}
	
	private void printAll() {
		Set<String> key = dept.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()) {
			String name = it.next(); // �̸� �˾Ƴ�
			Student student = dept.get(name); // �̸��� Ű���Ͽ� �ؽø����� Student ��ü ��
			System.out.println("---------------------------");
			System.out.println("�̸�:" + student.getName());
			System.out.println("�а�:" + student.getDepartment());
			System.out.println("�й�:" + student.getId());
			System.out.println("�������:" + student.getGrade());
			System.out.println("---------------------------");
		}		
	}

	private void processQuery() {
		while(true) {
			System.out.print("�л� �̸� >> ");
			String name = scanner.nextLine(); // �л� �̸� �Է�
			if(name.equals("�׸�"))
				return; // ����
			
			Student student = dept.get(name); // �ؽøʿ��� �̸��� Ű�� �˻�
			if(student == null) { // �̸��� �ؽøʿ� ���ٸ�
				System.out.println(name + " �л� �����ϴ�.");
			}
			else { // �ؽøʿ��� �˻���  Student ��ü
				System.out.print(student.getName() + ", ");
				System.out.print(student.getDepartment() + ", ");
				System.out.print(student.getId() + ", ");
				System.out.println(student.getGrade());
			}
		}
	}
	
	public void run() {
		read();
		printAll();
		processQuery();
	}
	
	public static void main (String[] args) {
		StudentManager man = new StudentManager();
		man.run();
	}
}
