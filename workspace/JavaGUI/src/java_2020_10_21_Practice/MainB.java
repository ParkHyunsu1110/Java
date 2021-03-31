package java_2020_10_21_Practice;

public class MainB {
	private MainFrameB mainFrameB;
	public MainB() {
		this.mainFrameB = new MainFrameB();
	}
	public void show() {
		this.mainFrameB.setVisible(true);
		this.mainFrameB.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainB mainB = new MainB();
		mainB.show();
	}

}
