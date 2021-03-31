import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class ScoreServerFrame extends JFrame {
	private ScoreManager scoreManager = null;
	private JTextArea log = new JTextArea();
	public ScoreServerFrame() {
		super("���� ��ȸ ����");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ���� ��ư(X)�� Ŭ���ϸ� ���α׷� ����
		Container c = getContentPane();
		c.add(new JLabel("���� ��ȸ �����Դϴ�"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		scoreManager = new ScoreManager("c:\\temp\\score.txt");
		if(scoreManager.isFileRead()) { // �ܾ� ������ �������� ��� ���� ����
			log.setText("score.txt �б� �Ϸ�\n");
			new ServerThread().start(); // ���� ����
		}
	}
	
	class ServerThread extends Thread {
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9998);
				while(true) {
					socket = listener.accept();
					log.append("Ŭ���̾�Ʈ �����\n");
					new ServiceThread(socket).start();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ScoreManager {
		private HashMap<String, String> map = new HashMap<String, String>();
		private boolean fileOn = false;
		
		public ScoreManager(String fileName) {
			try {
				Scanner reader = new Scanner(new FileReader(fileName));
				while(reader.hasNext()) {
					String name = reader.next();
					String score = reader.next();
					map.put(name, score);
				}
				reader.close();
				fileOn = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				fileOn = false;
			}
		}
		
		public boolean isFileRead() {
			return fileOn;
		}
		
		public String get(String name) { // map���� name�� score�� �˻��Ͽ� ����
			return map.get(name);
		}
	}
	
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		
		public ServiceThread(Socket socket) { // Ŭ���̾�Ʈ�� ����� ������ ���޹���
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					String name = in.readLine(); // Ŭ���̾�Ʈ�κ��� �̸� ����
					String score = scoreManager.get(name);
					if(score == null) {
						out.write("���� �̸�\n");
						log.append(name + " ����\n");
					}
					else { 
						out.write(score + "\n");
						log.append(name + ":" + score + "\n");				
					}
					out.flush();
				} catch (IOException e) {
					log.append("���� ����\n");
					System.out.println("���� ����");
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					return; // ������ ����
					//e.printStackTrace();
				}

			}
		}
	}
	public static void main(String[] args) {
		new ScoreServerFrame();
	}

}
