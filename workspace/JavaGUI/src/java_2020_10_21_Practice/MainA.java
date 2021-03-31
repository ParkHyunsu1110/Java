package java_2020_10_21_Practice;

public class MainA {
	private MainFrameA mainFrameA;
	public MainA() {
		this.mainFrameA = new MainFrameA();
	}
	public void show() {
		this.mainFrameA.setVisible(true);
		this.mainFrameA.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainA mainA = new MainA();
		mainA.show();
	}

}
