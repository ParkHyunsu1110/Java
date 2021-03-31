package java_2020_11_30_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setSize(500, 500);
		MouseAction mouse = new MouseAction();
		this.addMouseListener(mouse);
	}
	public void drawRect(int x, int y) {
		Graphics graphics = getGraphics();
		graphics.drawRect(x-50, y-50, 80, 80);
	}
	public void fillRect(int x, int y) {
		Graphics graphics = getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(x-50, y-50, 40, 40);
	}
	class MouseAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount() == 1) {
				drawRect(e.getX(), e.getY());
			}else {
				fillRect(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
