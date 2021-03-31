import java.util.ArrayList;

// MyStack�� push() ���� �߰��Ǵ� �������� �׻� �� �տ� �����Ѵ�.
// �׷��Ƿ� pop() ���� �� �տ� �ִ� �������� �����Ѵ�. 
public class MyStack<T> implements IStack<T> {
	ArrayList<T> l = null;
	public MyStack() {
		l = new ArrayList<T>();
	}

	@Override
	public T pop() {
		if (l.size() == 0)
			return null; 
		else {
			return l.remove(0); // �� �տ� �ִ� ������ ����
		}
	}

	@Override
	public boolean push(T ob) {
		l.add(0, ob); // �� ���� ���� 
		return true;
	}
}
