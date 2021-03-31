package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Server {

	private ServerSocket serverSocket;
	public int count;
	private Semaphore avaliable;
	
	// server - entity 내용 : 실제로 ValueObject
	public int getCount() {
		return this.count;
	}
	public int addCount() {
		try {
			this.avaliable.acquire();
			this.count = this.count + 1;
			this.avaliable.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.count;
	}
	// 여기까지 entity 내용

	public void initialize() {
		try {
			this.serverSocket = new ServerSocket( Constant.PORTNUMBER );
			this.avaliable = new Semaphore(1, true);
		} catch (IOException e) {
		}
	}

	public void run() {
		try {

			//wait & create session
			boolean bRunning = true;

			while(bRunning) {
				//client request for connection
				Socket clientSocket = this.serverSocket.accept();

				//create service for client
				Session session = new Session();

				session.initialize(clientSocket);
				session.start();
				// close connection
				//session.finalize();
			}

		} catch (IOException e) {
		}
	}

	public void finalize() {
		//close connection
		try {
			this.serverSocket.close();
		} catch (IOException e) {
		}
	}

}
