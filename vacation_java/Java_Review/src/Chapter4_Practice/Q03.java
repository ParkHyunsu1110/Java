package Chapter4_Practice;
/*
 * 프로그램명 : 노래 한곡을 나타 내는 Song클래스 작성하기
 * */

public class Q03 {
	private String title;
	private String artist;
	private int year;
	private String country;
	void show() { System.out.println( year + "년 " + country + "국적의 " + artist + "가 부른 " + title); }
	public Q03( String title, String artist, int year, String country) {
		this.title=title;
		this.artist=artist;
		this.year=year;
		this.country=country;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title="Dancing Queen";
		String artist="ABBA";
		int year=1978;
		String country="스웨덴";
		Q03 song = new Q03(title, artist, year, country);
		song.show();
	}

}
