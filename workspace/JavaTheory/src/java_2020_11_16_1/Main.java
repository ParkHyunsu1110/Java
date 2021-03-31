package java_2020_11_16_1;

public class Main {

	public static void main(String[] args) {
		Student kim = new Student();
		Student lee = new Student();
		
		kim.setName("원하는 이름 1");
		lee.setName("원하는 이름 2");
		
		kim.showName();
		lee.showName();
	}
}
