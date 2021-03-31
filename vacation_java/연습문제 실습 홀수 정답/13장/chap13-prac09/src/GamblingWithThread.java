import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamblingWithThread extends JFrame {
	public GamblingWithThread() {
		super("�����带 ���� �׺�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ������ ����Ѵ�. 

		setSize(300,220);
		setVisible(true);		
	}
	
	// ����Ʈ���� ���Ǵ� �г� Ŭ����
	class GamePanel extends JPanel {
		private JLabel [] label = new JLabel [3]; // 3 ���� ���� ǥ���ϴ� ���̺� �迭
		private JLabel result = new JLabel("���콺�� Ŭ���� �� ���� �����մϴ�."); // ����� ����ϴ� ���̺�
		private GamblingThread thread = new GamblingThread(label, result); // ���� ������
			
		public GamePanel() {
			setLayout(null); // ��ġ�����ڸ� ������� �ʰ� ���� ��ġ�� ������Ʈ�� ��ġ�Ѵ�.
			
			// 3 ���� ���̺��� �����Ͽ� �����̳ʿ� �ܴ�.
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel("0"); // ���̺� ����
				label[i].setSize(60, 30); // ���̺� ũ��
				label[i].setLocation(30+80*i, 50); // ���̺� ��ġ
				label[i].setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
				label[i].setOpaque(true); // ���̺� ���� ������ �����ϵ��� �Ѵ�.
				label[i].setBackground(Color.MAGENTA); // ���̺��� ������ �����Ѵ�.
				label[i].setForeground(Color.YELLOW); //���̺��� ���� ���� �����Ѵ�.				
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30)); // ���̺� ������ ��Ʈ�� �����Ѵ�.	
				add(label[i]); // ���̺��� �����Ѵ�.
			}
			
			// ����� ����� ���̺��� �����ϰ� �����̳ʿ� �����Ѵ�.
			result.setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
			result.setSize(250, 20);
			result.setLocation(30, 120);
			add(result);
			thread.start();
			
			// ���콺 �����ʸ� �����Ѵ�.
			addMouseListener(new MouseAdapter() { // MouseAdapter �̿�
				@Override
				public void mousePressed(MouseEvent e) {
					if(thread.isReady()) // �����尡 ���� ���̸� �׳� ����
						thread.startGambling();
				}
			});
		}
	}
	
	class GamblingThread extends Thread {
		private JLabel [] label; //���� ���ڸ� ����ϴ� ���̺�
		private JLabel result; // ����� ����ϴ� ���̺�
		private long delay = 200; // ���� �ð��� �ʱ갪 = 200
		private boolean gambling = false; // ������ �� ������. �ʱ갪 = false
		
		public GamblingThread(JLabel [] label, JLabel result) {
			this.label = label;
			this.result = result;
		}
		
		boolean isReady() {
			return !gambling; // ���� ���̸� �غ���� �ʾ���
		}
		
		synchronized public void waitForGambling() {
			if(!gambling) // ���콺 Ŭ���� ���� gambling�� true�� �ƴϸ� ��ٸ�
				try {
					this.wait();
				} catch (InterruptedException e) { return; }
		}
		
		synchronized public void startGambling() {
			gambling = true; // ���콺 Ŭ������ �����尡 ������ �����ϵ��� ����
			this.notify(); // ��ٸ��� �����带 ����
		}		
		
		@Override
		public void run() {
			while(true) {
				waitForGambling(); // ���콺 Ŭ���� ���� ���� ���� ���ø� ��ٸ�
				try {
					int x1 = (int)(Math.random()*5); // 0~4������ ������
					int x2 = (int)(Math.random()*5); // 0~4������ ������
					int x3 = (int)(Math.random()*5); // 0~4������ ������
					
					// ù��° �� ����
					label[0].setForeground(Color.BLUE); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[0].setForeground(Color.YELLOW);
					label[0].setText(Integer.toString(x1));
					
					// �ι�° �� ����					
					label[1].setForeground(Color.BLUE); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[1].setForeground(Color.YELLOW);					
					label[1].setText(Integer.toString(x2));
					
					// ����° �� ����
					label[2].setForeground(Color.BLUE); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[2].setForeground(Color.YELLOW);					
					label[2].setText(Integer.toString(x3));	
					
					// ������ �����Ͽ����� �Ǻ�
					if(x1 == x2 && x2 == x3)
						result.setText("�����մϴ�!!");
					else 
						result.setText("�ƽ�����");
					gambling = false; // ���� ���� ������ �����ϵ��� ����
				} catch (InterruptedException e) { return; }
			}
		}	
	}
	
	public static void main(String[] args) {
		new GamblingWithThread();
	}
}

