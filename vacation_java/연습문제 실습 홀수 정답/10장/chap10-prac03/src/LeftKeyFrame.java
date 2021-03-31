import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LeftKeyFrame extends JFrame {
	public LeftKeyFrame() {
		super("Left Ű�� ���ڿ� ��ü");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel la = (JLabel)e.getSource();
					StringBuffer text  = new StringBuffer(la.getText());
					la.setText(text.reverse().toString());
				}
			}
		});
		c.add(label);
		setSize(250,100);
		setVisible(true);
		
		label.setFocusable(true); // ���̺��� ��Ŀ���� ���� �� �ֵ��� ����
		label.requestFocus(); // ���̺� Ű �Է� ��Ŀ�� ����
	}
	static public void main(String [] args) {
		new LeftKeyFrame();
	}
}
