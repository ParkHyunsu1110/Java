package Chapter4_Practice;
/*
 * ���α׷��� : �뷡 �Ѱ��� ��Ÿ ���� SongŬ���� �ۼ��ϱ�
 * */

public class Q03 {
	private String title;
	private String artist;
	private int year;
	private String country;
	void show() { System.out.println( year + "�� " + country + "������ " + artist + "�� �θ� " + title); }
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
		String country="������";
		Q03 song = new Q03(title, artist, year, country);
		song.show();
	}

}
