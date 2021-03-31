package game;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class omokeGUI extends JFrame {
	private Container container;
	omokeMapSize size = new omokeMapSize();
	
	public omokeGUI(String title) {
		container = getContentPane();
		this.setSize(650, 700);
//		this.setBounds(200,20,650,700);
//		this.setLayout(null);
		omokeMap map = new omokeMap(size);
		omokeDrawBoard drawBoard = new omokeDrawBoard(size, map);
		this.setContentPane(drawBoard);
		this.addMouseListener(new omokeMouseEventHandler(map, size, drawBoard, this));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message, "", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
		this.repaint();
	}
}
