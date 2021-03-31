package java_2020_11_18_2;
import java.util.Vector;
public class Library {
	
	Vector<String> bookList;
	String name; 
	String libraryName;
	String location;
	
	public Library() {
		bookList = new Vector<String>();
		name = "사서이름";
		libraryName = "도서관이름";
		location = "위치";
	}
	public void addBook(String bookName) {
		bookList.add(bookName);
	}
	public void showBook() {
		for(int i=0; i<bookList.size(); i++)
			System.out.println(bookList.get(i));
	}
	public void changeName(String newName) {
		name = newName;
	}
	public void showInfo() {
		System.out.println(libraryName + " " + location);
	}
}
