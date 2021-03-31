package java_2020_11_02_2;

public class Main {
	private NullFrame nullFrame;
	private CardLayoutFrame cardLayoutFrame;
	public Main() {
		//this.nullFrame = new NullFrame();
		this.cardLayoutFrame = new CardLayoutFrame();
	}
	public void show() {
		//this.nullFrame.setVisible(true);
		//this.nullFrame.setLocationRelativeTo(null);
		this.cardLayoutFrame.setVisible(true);
		this.cardLayoutFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.show();
	}
}
