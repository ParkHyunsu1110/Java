package Chapter4;
/*
 * ���α׷��� : ������ ���� �� Ȱ��
 * */
public class D_Book {
	String title;
	String author;
	public D_Book(String t) {
		title = t;
		author="���� �̻�";
	}
	public D_Book(String t, String a) {
		title = t;
		author = a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D_Book littlePrince = new D_Book("�����", "�������丮");
		D_Book loveStory = new D_Book("������");
		
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
	}

}
