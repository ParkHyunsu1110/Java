package java_2020_11_30_4;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GDrawingPanel extends JPanel {
	private String currentTool;
	private MouseHandler mouseHandler;
	
	public GDrawingPanel() {
		this.currentTool = "네모";
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
	}
	public void setCurrentTool(String currentTool) {
		this.currentTool = currentTool;
	}
	public void draw( int x, int y, int width, int height) {
		Graphics g =  getGraphics();
		
		g.setXORMode(getBackground());
		
		if( currentTool.contentEquals("네모")) {
			g.drawRect(x, y, width, height);
		}
		else if( currentTool.contentEquals("원")) {
			g.drawOval(x, y, width, height);
		}
		else if( currentTool.contentEquals("선")) {
			g.drawLine(x, y, x + width, y + height);
		}
	}
	public class MouseHandler implements MouseListener, MouseMotionListener{
		private int x1, y1, w, h;
		@Override
		public void mouseDragged(MouseEvent e) {
			draw(x1, y1, w, h);
			
			int x2 = e.getX();
			int y2 = e.getY();
			
			w = x2 - x1;
			h = y2 - y1;
			
			draw(x1, y1, w, h);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			this.x1 = e.getX();
			this.y1 = e.getY();
			
			w = 0;
			h = 0;
		}
		
		@Override
		public void mouseMoved(MouseEvent e) { }
		@Override
		public void mouseClicked(MouseEvent e) { }
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		
	}
}
