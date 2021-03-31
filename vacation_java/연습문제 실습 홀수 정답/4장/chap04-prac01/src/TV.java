
public class TV {
	private String manufacturer;
	private int year;
	private int size;
		
	public TV(String manufacturer, int year, int size) {
		this.manufacturer = manufacturer;
		this.year = year;		
		this.size = size;
	}
	
	public void show() {
		System.out.print(this.manufacturer + "���� ���� ");
		System.out.print(this.year + "���� ");
		System.out.println(this.size + "��ġ TV");
	}
	
	public static void main(String [] args) {
		TV myTV = new TV("LG", 2017, 32); // LG���� ���� 2017�� 65��ġ
		myTV.show();
	}
}

