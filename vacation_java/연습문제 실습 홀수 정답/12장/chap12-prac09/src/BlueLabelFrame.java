import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlueLabelFrame extends JFrame {
	public BlueLabelFrame(){
		super("Blue Label �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// BlueLabel�� �׽�Ʈ�ϱ� ���� �� ���� ���̺��� �����.
		BlueLabel blueLabel1 = new BlueLabel("hello");
		blueLabel1.setBackground(Color.RED); // ������ ���������� �Ϻη� �����غ���. �ݿ����� �ʴ´�.
		blueLabel1.setForeground(Color.YELLOW);
		c.add(blueLabel1);
		
		BlueLabel2 blueLabel2 = new BlueLabel2("Big Hello");
		blueLabel2.setOpaque(true);
		blueLabel2.setFont(new Font("TimesRoman", Font.ITALIC, 50));
		blueLabel2.setBackground(Color.RED); // ������ ���������� �Ϻη� �����غ���. �ݿ����� �ʴ´�.
		blueLabel2.setForeground(Color.MAGENTA);
		c.add(blueLabel2);
		
		setSize(300,200);
		setVisible(true);
	}
	
	static public void main(String[] args) {
		new BlueLabelFrame();
	}
}

// JLabel�� ��ӹ޾� ���� �׻� Ǫ�������� ���̺�
// paintComponent()�� �̿��ϴ� ���
class BlueLabel extends JLabel {
	public BlueLabel(ImageIcon icon) {
		super(icon);
	}
	public BlueLabel(String text) {
		super(text);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0,this.getWidth(), this.getHeight());
		super.paintComponent(g); // ���� JLabel�� �׸��� �ڵ带 �״�� ȣ��
	}
}

//JLabel�� ��ӹ޾� ���� �׻� Ǫ�������� ���̺�
//setBackground()�� �������̵� �ϴ� ���
class BlueLabel2 extends JLabel {
	public BlueLabel2(ImageIcon icon) {
		super(icon);
	}
	public BlueLabel2(String text) {
		super(text);
	}	
	
	@Override
	public void setBackground(Color c) {
		super.setBackground(Color.BLUE);
		return;
	}
}
