package java_2020_11_09_2;
public class Main {
	private MainFrame mainFrame;
	public Main() { this.mainFrame = new MainFrame(); }
	public void show() {
		this.mainFrame.setVisible(true);
		this.mainFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.show();
	}
}
