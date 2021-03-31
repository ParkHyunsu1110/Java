package Chapter4;
/*
 * 프로그램명 : this()로 다른 생성자 호출
 * */
public class E_Book {
	String title;
	String author;
	
	void show() { System.out.println(title + " " + author);}
	
	public E_Book() {
		this("", "");
		System.out.println("생성자 호출됨 ");
	}
	public E_Book(String title) {
		this(title,"작자 미상");
	}
	public E_Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E_Book littlePrince = new E_Book("어린왕자", "생텍쥐페리");
		E_Book loveStory = new E_Book("춘향전");
		E_Book emptyBook = new E_Book();
		loveStory.show();
	}

}
