import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class AudioStartAndStopFrame extends JFrame {
	private Clip clip = null;
	private AudioInputStream audioStream = null;
	private JLabel msgLabel = new JLabel("");
	
	public AudioStartAndStopFrame() {
		super("����� ���� �ߴ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.setLayout(new FlowLayout());
		msgLabel.setFont(new Font("Gothic", Font.PLAIN, 15));
		c.add(msgLabel);
		setSize(300,150);
		setVisible(true);
		
		playAudio("audio\\hiphop.wav");
		msgLabel.setText("audio\\hiphop.wav ���� ��");
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				msgLabel.setText("audio\\hiphop.wav ���� ���");
				clip.start(); // �ߴܵ� ��ġ�������� ����				
			}
			
		 	@Override
			public void mouseExited(MouseEvent e) {
				msgLabel.setText("audio\\hiphop.wav ���� �Ͻ� �ߴ�");
				clip.stop(); // �ߴܵ� ��ġ�������� ����				
			}

		});
	}
	
	private void playAudio(String pathName) {
		try {
			File audioFile = new File(pathName); // ����� ������ ��θ�
			audioStream = AudioSystem.getAudioInputStream(audioFile); // ����� ���Ϸκ���
			
			clip = AudioSystem.getClip(); // ����ִ� ����� Ŭ�� �����
			clip.open(audioStream); // ����� ����� ��Ʈ�� ����
			clip.start(); // ��� ����
		}
		catch (LineUnavailableException e) { e.printStackTrace(); }
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}

	static public void main(String[] arg) {
		new AudioStartAndStopFrame();
	}
}

