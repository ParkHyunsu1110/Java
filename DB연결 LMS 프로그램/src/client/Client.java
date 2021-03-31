package client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import server.Constant;

public class Client {
	// attributes - server info
	private String IP; // Client가 접속할 주소
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
			JOptionPane.showConfirmDialog(null, "서버가 준비되지 않습니다. 클라이언트 프로그램을 종료합니다.", "EROR", JOptionPane.OK_CANCEL_OPTION);
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
