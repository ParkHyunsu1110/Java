package java_2020_12_07_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class GDrawingPanel extends JPanel {
	private Vector<Point> vStart;
	
	private String currentTool;

	private MouseHandler mouseHandler;
	private Color color;

	public GDrawingPanel() {
		this.currentTool = "°î¼±";
		this.color = Color.BLUE;
		this.vStart = new Vector<Point>();
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
	}

	public void setCurrentTool(String currnetTool) {
		this.currentTool = currnetTool;
	}

	public void setCurrentColor(String currentColor) {

		if (currentColor.contentEquals("»¡°­")) {
			color = Color.RED;
		} else if (currentColor.contentEquals("³ë¶û")) {
			color = Color.YELLOW;
		} else if (currentColor.contentEquals("ÆÄ¶û")) {
			color = Color.BLUE;
		} else if (currentColor.contentEquals("°ËÁ¤")) {
			color = Color.BLACK;
		} else if (currentColor.contentEquals("ÇÏ¾ç")) {
			color = Color.WHITE;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		
		for (int i = 1; i < vStart.size(); i++) {
			if (vStart.get(i - 1) == null) {
				continue;
			} else if(vStart.get(i) == null){
				continue;
			} else {
				g.drawLine((int) vStart.get(i-1).getX(), (int) vStart.get(i-1).getY(), (int) vStart.get(i).getX(), (int) vStart.get(i).getY());
			}

		}
	}
	
	public class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			vStart.add(e.getPoint());
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			vStart.add(null);
			vStart.add(e.getPoint());
		}

		@Override
		public void mouseMoved(MouseEvent arg0) { }

		@Override
		public void mouseClicked(MouseEvent arg0) { }

		@Override
		public void mouseEntered(MouseEvent arg0) { }

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { }

	}
}