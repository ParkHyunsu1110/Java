package java_2020_11_30_1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PracticeFrame extends JFrame {
	public PracticeFrame() {
		this.setSize(500, 500);
	}
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.setColor(new Color(137, 4, 177));
		graphics.fillRect(50, 50, 100, 100);
		
		graphics.setColor(Color.YELLOW);
		graphics.fillOval(200, 200, 50, 50);
		
		graphics.setColor(Color.BLACK);
		graphics.drawLine(250, 250, 350, 350);
		graphics.drawLine(250, 350, 350, 250);
	}
}
