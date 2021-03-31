package java_2020_11_18_1;

public class Zoo {
	public String zooName, ceoName;
	public int entranceFee;
	public Zoo() { 
		zooName = "동물동물원";
		ceoName = "박현수";
		entranceFee = 8000;
	}
	public void showInfo() {
		System.out.println(zooName + " " + ceoName + " " + entranceFee);
	}
}
