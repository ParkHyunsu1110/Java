import javax.swing.*;

public class SimpleMenuFrame extends JFrame {
	public SimpleMenuFrame() {
		super("�޴� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		setSize(300,200);
		setVisible(true);
	}
	private void createMenu() {
		JMenu fileMenu = new JMenu("����");
		JMenu editMenu = new JMenu("����");
		JMenu viewMenu = new JMenu("����");
		viewMenu.add(new JMenuItem("ȭ��Ȯ��"));
		viewMenu.add(new JMenuItem("������"));
		JMenu inputMenu = new JMenu("�Է�");
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(viewMenu);
		mb.add(inputMenu);		
		setJMenuBar(mb);		
	}
	static public void main(String[] arg) {
		new SimpleMenuFrame();
	}
}
