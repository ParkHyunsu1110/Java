package java_2020_11_30_1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setSize(500, 500);
	}
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		graphics.drawRect(50, 50, 100, 100);
		graphics.setColor(Color.CYAN);
		graphics.fillOval(300, 300, 150, 150);
		graphics.setColor(new Color(0, 0, 0));
		graphics.drawLine(100, 350, 300, 200);
	}
}
