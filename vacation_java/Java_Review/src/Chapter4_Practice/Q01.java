package Chapter4_Practice;
/*
 * ���α׷��� : ������ Ŭ���� �����
 * */
public class Q01 {
	String com;
	int year;
	int inch;
	void show() { System.out.println( com + "���� ���� " + year + "���� " + inch + "��ġ TV" );}
	public Q01(String com, int year, int inch){
		this.com = com;
		this.year = year;
		this.inch = inch;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q01 myTV = new Q01("LG", 2017, 32);
		myTV.show();
	}

}
