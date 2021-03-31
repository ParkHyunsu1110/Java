package java_2020_11_09_2;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	JPanel panel;
	JLabel label;
	int size;
	KeyAdapter keyAdapter = new KeyAdapter();
	public MainFrame() {
		this.setSize(300, 300);
		panel = new JPanel();
		label = new JLabel("LOVE");
		size = 10;
		label.setFont(new Font("Arial", Font.PLAIN, size));
		this.addKeyListener(keyAdapter);
		panel.add(label);
		this.add(panel);
	}
	public class KeyAdapter implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			size = label.getFont().getSize();
			switch(e.getKeyChar()) {
				case 61:
					label.setFont(new Font("Arial", Font.PLAIN, size+10));
					break;
				case 45:
					if(size>5)
						label.setFont(new Font("Arial", Font.PLAIN, size-5));
					break;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) { }
		@Override
		public void keyTyped(KeyEvent e) { }		
	}
}
