public class StringStack implements Stack {
	private String[] element; // ������ ���� �޸�
	private int tos; // index, top of stack
	
	public StringStack(int capacity) {
		element = new String[capacity];
		tos = -1;
	}
	
	// Stack �������̽��� ����� ���� 3���� �޼ҵ� �������̵� ����
	@Override
	public int length() { // ���� ���ÿ� ����� ���� ����
		return tos+1;
	}
	
	@Override
	public int capacity() { // ���� ���ÿ� ����� ���� ����
		return element.length;
	}
	
	@Override
	public String pop() {
		if(tos == -1) // ������ �����
			return null;
		String s = element[tos]; // �鿡 �ִ� ��
		tos--; // ���� ������ ����
		return s;
	}

	@Override
	public boolean push(String str) {
		if(tos == element.length-1)
			return false; // ������ �� á��
		else {
			tos++;
			element[tos] = str; // ��� ���ÿ� ���� �� ���� ������ ����
			return true;
		}
	}
}