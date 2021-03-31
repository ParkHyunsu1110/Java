import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AudioMenuFrame extends JFrame {
	private JFileChooser chooser = null;
	private Clip clip = null;
	private AudioInputStream audioStream = null;
	private JLabel msgLabel = new JLabel("����� ������ �����ϼ���");
	
	public AudioMenuFrame() {
		super("����� ������ ã�� ����/���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		msgLabel.setFont(new Font("Gothic", Font.PLAIN, 15));
		msgLabel.setHorizontalAlignment(JLabel.CENTER);
		c.add(msgLabel);
		
		createMenu();

		setSize(450,150);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenu audioMenu = new JMenu("�����");
		JMenuItem playItem = new JMenuItem("����");
		audioMenu.add(playItem);

		JMenuItem stopItem = new JMenuItem("����");
		audioMenu.add(stopItem);
	
		JMenuBar mb = new JMenuBar();
		mb.add(audioMenu);
		setJMenuBar(mb);
		
		playItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String filePath = chooseFile();
				if(filePath == null)
					return; // ������ ���õ��� �ʾ���
				
				if(clip != null && clip.isActive())
					clip.close();

				playAudio(filePath);
				msgLabel.setText(new File(filePath).getName() + " �� �����ϰ� �ֽ��ϴ�.");
			}
		});
		
		stopItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clip != null && clip.isActive()) {
					clip.close();
					msgLabel.setText("���ָ� �����մϴ�.");					
				}
			}
		});

	}
	
	private String chooseFile() {
		if(chooser == null) // ó���̸�, �ƴϸ� ������ ���� chooser �̿�
			chooser= new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Audio Files(wav,au, mid, rmf)", "wav", "au", "mid",  "rmf");
	    chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(AudioMenuFrame.this);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(AudioMenuFrame.this, "������ �������� �ʾҽ��ϴ�", 
						"���", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		String filePath = chooser.getSelectedFile().getPath();
		return filePath;
	}
	
	private void playAudio(String pathName) {
		try {
			File audioFile = new File(pathName); // ����� ������ ��θ�
			audioStream = AudioSystem.getAudioInputStream(audioFile); // ����� ���Ϸκ���
			
			clip = AudioSystem.getClip(); // ����ִ� ����� Ŭ�� �����
			clip.addLineListener(new MyLineListener());
			clip.open(audioStream); // ����� ����� ��Ʈ�� ����
			clip.start(); // ��� ����
		}
		catch (LineUnavailableException e) { e.printStackTrace(); }
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	class MyLineListener implements LineListener {
		@Override
		public void update(LineEvent e) {
			if (e.getType() == LineEvent.Type.STOP) { // clip.stop()�� ȣ��ǰų� ����� ������ ��
				try {
					audioStream.close(); // ���� ���ֵǴ� ����� ��Ʈ�� �ݱ�
					msgLabel.setText("���ָ� �����Ͽ����ϴ�.");			
				} catch (IOException e1) {
					e1.printStackTrace();		
				}
            }
		}
	}
	static public void main(String[] arg) {
		new AudioMenuFrame();
	}
	
	
}

