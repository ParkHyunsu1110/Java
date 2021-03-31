package java_2020_12_02_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GDrawingPanel extends JPanel {
	private String currentTool;
	
	private MouseHandler mouseHandler;
	private Color color;
	
	public GDrawingPanel() {
		this.currentTool = "�׸�";
		this.color = Color.white;
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
	}
	public void setCurrentTool(String currnetTool) {
		this.currentTool = currnetTool;
	}
	public void setCurrentColor(String currentColor) {
		
		
		if(currentColor.contentEquals("����")) {
			color = Color.RED;
		}
		else if(currentColor.contentEquals("���")) {
			color = Color.YELLOW;
		}
		else if(currentColor.contentEquals("�Ķ�")) {
			color = Color.BLUE;
		}
		else if(currentColor.contentEquals("����")) {
			color = Color.BLACK;
		}
		else if(currentColor.contentEquals("�Ͼ�")) {
			color = Color.WHITE;
		}
	}
	public void draw(int x, int y, int width, int height) {
		Graphics g = getGraphics();
		
		g.setXORMode(getBackground());
		g.setColor(color);
		
		if(currentTool.contentEquals("�׸�")) {
			g.fillRect(x, y, width, height);
		}
		else if(currentTool.contentEquals("��")) {
			g.fillOval(x, y, width, height);
		}
		else if(currentTool.contentEquals("��")) {
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
