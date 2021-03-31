import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ToolBarAndOptionPaneFrame extends JFrame {
	public ToolBarAndOptionPaneFrame() {
		super("���� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JToolBar tBar = new JToolBar();
		JButton btn = new JButton("����");
		btn.addActionListener(new CloseActionListener());
		tBar.add(btn);
		c.add(tBar, BorderLayout.NORTH); // ���ٴ� �ݵ�� BorderLayout ��ġ�����ڰ� �ִ� �����̳ʿ� �ٿ��� ��
		
		setSize(400,400);
		setVisible(true);
	}
	
	class CloseActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�", "�ɼ���", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				// ����ڰ� "��"�� "�ƴϿ�"�� ���þ��� ���̾�α�â������ ���
				return; // not exited
			}
			else if(result == JOptionPane.YES_OPTION) {
				// ����ڰ� "��"�� ������ ���
				System.exit(0);
			}
			else {	// ����ڰ� "�ƴϿ�"�� ������ ���
				return; // not exited
			}
		}
	}
	
	static public void main(String[] arg) {
		new ToolBarAndOptionPaneFrame();
	}
}
