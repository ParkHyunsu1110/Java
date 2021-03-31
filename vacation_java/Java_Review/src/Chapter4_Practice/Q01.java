package Chapter4_Practice;
/*
 * 프로그램명 : 간단한 클래스 만들기
 * */
public class Q01 {
	String com;
	int year;
	int inch;
	void show() { System.out.println( com + "에서 만든 " + year + "년형 " + inch + "인치 TV" );}
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
