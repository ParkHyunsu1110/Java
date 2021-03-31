package java_2020_10_26_2;

public class Main {
	private MainFrame mainFrame;
	public Main() {
		this.mainFrame = new MainFrame();
	}
	public void show() {
		this.mainFrame.setVisible(true);
		this.mainFrame.setResizable(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.show();
	}
}
