import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ScoreClientFrame extends JFrame {
	private JTextField nameTf = new JTextField(7);
	private JLabel resLabel = new JLabel("����");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	public ScoreClientFrame() {
		super("����üũ Ŭ���̾�Ʈ");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ���� ��ư(X)�� Ŭ���ϸ� ���α׷� ����
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("�̸� �Է� "));
		c.add(nameTf);
		c.add(resLabel);
		
		setVisible(true);
	
		setupConnection();
		
		nameTf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				try {
					String name = tf.getText().trim();					
					if(name.length() == 0)
						return; // �Էµ��� �ʾ���
					
					out.write(name + "\n");
					out.flush();
					
					String score = in.readLine();
					resLabel.setText("���� " + score);
				} catch (IOException e1) {
					System.out.println("Ŭ���̾�Ʈ : �����κ��� ���� ����");
					return;
					// e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public void setupConnection() {
		try {
			socket = new Socket("localhost", 9998);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ScoreClientFrame();
	}

}
