package java_2020_10_26_1;

public class MainEvent {
	private MainEventFrame1 mainEventFrame1;
	private MainEventFrame2 mainEventFrame2;
	public MainEvent() {
		this.mainEventFrame1 = new MainEventFrame1();
		this.mainEventFrame2 = new MainEventFrame2();
	}
	public void show() {
		this.mainEventFrame1.setVisible(true);
		this.mainEventFrame1.setLocationRelativeTo(null);
		this.mainEventFrame2.setVisible(true);
		this.mainEventFrame2.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainEvent mainEvent = new MainEvent();
		mainEvent.show();
	}
}
