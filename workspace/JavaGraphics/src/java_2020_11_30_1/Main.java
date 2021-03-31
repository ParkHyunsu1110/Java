package java_2020_11_30_1;

public class Main {
	//private MainFrame mainFrame;
	private PracticeFrame practiceFrame;
	public Main() {
		//this.mainFrame = new MainFrame();
		this.practiceFrame = new PracticeFrame();
	}
	public void show() {
		//this.mainFrame.setVisible(true);
		//this.mainFrame.setLocationRelativeTo(null);
		this.practiceFrame.setVisible(true);
		this.practiceFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.show();
	}
}
