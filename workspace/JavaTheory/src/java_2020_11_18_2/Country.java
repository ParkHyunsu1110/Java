package java_2020_11_18_2;
public class Country {
	private String country, continent, language, capital;
	private int goods;
	public Country() {
		country="���ѹα�";
		continent="�ƽþ�";
		language="�ѱ�";
		capital="����";
		goods=8000;
	}
	public void changeValue(String country, int goods, String continent, String capital) {
		this.country = country;
		this.goods = goods;
		this.continent = continent;
		this.capital = capital;
	}
	public void showInfo() {
		System.out.println(country + " " + continent + " " + capital);
	}
	public int tripleMoney() {
		goods = goods * 3;
		return goods;
	}
}
