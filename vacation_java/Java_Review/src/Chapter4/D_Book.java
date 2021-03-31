package Chapter4;
/*
 * 프로그램명 : 생성자 선언 및 활용
 * */
public class D_Book {
	String title;
	String author;
	public D_Book(String t) {
		title = t;
		author="작자 미상";
	}
	public D_Book(String t, String a) {
		title = t;
		author = a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D_Book littlePrince = new D_Book("어린왕자", "생텍쥐페리");
		D_Book loveStory = new D_Book("춘향전");
		
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
	}

}
