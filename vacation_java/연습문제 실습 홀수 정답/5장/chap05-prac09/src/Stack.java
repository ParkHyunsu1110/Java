interface Stack {
	int length(); // ���� ���ÿ� ����� ���� ����
	int capacity(); // ������ ��ü ���� ������ ���� ����
	String pop(); // ������ ��(top)�� �Ǽ� ����
	boolean push(String val); // ������ ��(top)�� ����� �Ǽ� ����
}