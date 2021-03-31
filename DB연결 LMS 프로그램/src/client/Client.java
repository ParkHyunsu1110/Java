package client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import server.Constant;

public class Client {
	// attributes - server info
	private String IP; // Client�� ������ �ּ�
	private int portNumber;
	private Socket socket;
	private Session session;
	private MainClient mainClient;

	public Client() {
		// set attributes
		this.portNumber = Constant.PORTNUMBER;
		this.IP = Constant.IP;
	}

	public void initialize() {
		try {
			//initialize socket streams
			this.socket = new Socket(this.IP, this.portNumber);
			this.session = new Session(this.socket);
			this.session.initialize();
		} catch(IOException e) {
			JOptionPane.showConfirmDialog(null, "������ �غ���� �ʽ��ϴ�. Ŭ���̾�Ʈ ���α׷��� �����մϴ�.", "EROR", JOptionPane.OK_CANCEL_OPTION);
			System.exit(0);

		}
	}

	public void run() {
		this.mainClient = new MainClient(this.session);
		this.mainClient.initialize();
		this.mainClient.run();
	}

	public void finalize() {
		try {		
			this.socket.close();
			this.session.finalize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
