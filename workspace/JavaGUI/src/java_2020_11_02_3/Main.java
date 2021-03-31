package java_2020_11_02_3;

public class Main {
	private MainFrame mainFrame;
	public Main() {
		this.mainFrame = new MainFrame();
	}
	public void show() {
		this.mainFrame.setVisible(true);
		this.mainFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.show();
	}

}
