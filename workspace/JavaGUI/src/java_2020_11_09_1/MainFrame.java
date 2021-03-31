package java_2020_11_09_1;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	JPanel panel;
	MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter(); 
	public MainFrame() {
		this.setSize(300, 300);
		panel = new JPanel();
		panel.setBackground(Color.green);
		panel.addMouseMotionListener(mouseMotionAdapter);
		this.add(panel);
	}
	public class MouseMotionAdapter implements MouseMotionListener {
		@Override
		public void mouseMoved(MouseEvent arg0) {
			panel.setBackground(Color.green);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			panel.setBackground(Color.YELLOW);
		}
	}
}
