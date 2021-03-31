package java_2020_11_25_3;

public class Building {
	private String address;
	private String mailNumber;
	private String host;
	private float height;
	private int maxFloor;
	
	public Building() { }
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMailNumber(String mailNumber) {
		this.mailNumber = mailNumber;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setheight(float height) {
		this.height = height;
	}
	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}
	
	public String getAddress() {
		return this.address;
	}
	public String getMailNumber() {
		return this.mailNumber;
	}
	public String getHost() {
		return this.host;
	}
	public float getFloor() {
		return this.height;
	}
	public int getMAxFloor() {
		return this.maxFloor;
	}
}
