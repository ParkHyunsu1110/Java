import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlusMinusImageFrame extends JFrame {
	public PlusMinusImageFrame(){
		super("�׷��� �̹��� Ȯ�� ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.jpg");		
		private Image img = icon.getImage();
		private int width, height;
		
		public MyPanel() {
			// �̹����� ���� ũ�� ���
			width = img.getWidth(this);
			height = img.getHeight(this);
			
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == '+') {
						// �׷��� �̹��� ũ�� Ȯ��
						width = (int)(width*1.1);
						height = (int)(height*1.1);	
						repaint(); // �ٽ� �׸��� ����
					}
					else if(e.getKeyChar() == '-') {
						// �׷��� �̹��� ũ�� ���						
						width = (int)(width*0.9);
						height = (int)(height*0.9);
						repaint(); // �ٽ� �׸��� ����						
					}
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 10, 10, width, height, this);
		}		
	}
	
	
	static public void main(String[] args) {
		new PlusMinusImageFrame();
	}
}
