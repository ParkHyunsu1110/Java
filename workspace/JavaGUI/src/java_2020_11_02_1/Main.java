package java_2020_11_02_1;

public class Main {
	private FlowLayoutFrame flowLayoutFrame;
	private BoxLayoutFrame boxLayoutFrame;
	private BorderLayoutFrame borderLayoutFrame;
	public Main() {
		//this.flowLayoutFrame = new FlowLayoutFrame();
		//this.boxLayoutFrame = new BoxLayoutFrame();
		this.borderLayoutFrame = new BorderLayoutFrame();
	}
	public void show() {
		//this.flowLayoutFrame.setVisible(true);
		//this.flowLayoutFrame.setLocationRelativeTo(null);
		//this.boxLayoutFrame.setVisible(true);
		//this.boxLayoutFrame.setLocationRelativeTo(null);
		this.borderLayoutFrame.setVisible(true);
		this.borderLayoutFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.show();
	}
}
