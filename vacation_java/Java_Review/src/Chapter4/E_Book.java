package Chapter4;
/*
 * ���α׷��� : this()�� �ٸ� ������ ȣ��
 * */
public class E_Book {
	String title;
	String author;
	
	void show() { System.out.println(title + " " + author);}
	
	public E_Book() {
		this("", "");
		System.out.println("������ ȣ��� ");
	}
	public E_Book(String title) {
		this(title,"���� �̻�");
	}
	public E_Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E_Book littlePrince = new E_Book("�����", "�������丮");
		E_Book loveStory = new E_Book("������");
		E_Book emptyBook = new E_Book();
		loveStory.show();
	}

}
