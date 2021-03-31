package Chapter4;
/*
 * 프로그램명 : 객체 배열 만들기 연습
 * */
import java.util.Scanner;

class gBook{
	String title,author;
	public gBook(String title, String author) {
		this.title = title;
		this.author = author;
	}
}
public class G_Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gBook [] book = new gBook[2];
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<book.length; i++) {
			System.out.print("책제목>>"); String title = scanner.nextLine();
			System.out.print("작가>>"); String author = scanner.nextLine();
			book[i] = new gBook(title,author);
		}
		for(int i=0; i<book.length; i++)
			System.out.print("(" + book[i].title + " , " + book[i].author + ")");
		
		scanner.close();
	}
}
