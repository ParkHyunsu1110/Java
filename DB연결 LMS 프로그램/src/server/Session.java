package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Vector;

import valueobject.VOLecture;
import valueobject.VOMember;

public class Session extends Thread{
	//association
	private Socket clientSocket;
	//components
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private OutputStream outputStream;
	private ObjectOutputStream objectOutputStream;

	public Session() {
	}

	public void initialize(Socket clientSocket) {
		try {
			//associate clientSocket
			this.clientSocket = clientSocket;

			//create buffered reader
			this.bufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

			//create print writer
			this.outputStream = this.clientSocket.getOutputStream();
			this.objectOutputStream = new ObjectOutputStream(this.outputStream);
			this.printWriter = new PrintWriter(this.outputStream, true);

			System.out.println("Server::initialize()");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			System.out.println("ServerThread::start()");
			
			boolean bRunning = true;
			while(bRunning) {
				//read data from client
				String line;
				line = this.bufferedReader.readLine();
			
				System.out.println("line : " + line);
				
				if(line.equals("quit")) {
					bRunning = false;
					
					this.printWriter.println(line);
					this.printWriter.flush();
				}else {
					String[] protocol = line.split("/");
					// 정해놓은 클래스이름/함수이름/인자  프로토콜을 "/"을 기준으로 나눈다.

					String classname = "service." + protocol[0];
					
					Class<?> myclass = Class.forName(classname);
					// 클라이언트가 보낸 이름의 클래스를 만든다.
					Object obj = myclass.newInstance();
					 if(protocol.length > 3 && protocol[3].equals("all")){
							Class[] methodParamClass = new Class[] {String.class, String.class};
							Object[] methodParamObject = new Object[] {protocol[2], protocol[3]};
							
							Method method = myclass.getMethod(protocol[1], methodParamClass);
							Vector<VOMember> voMember = (Vector<VOMember>)method.invoke(obj, methodParamObject);
							this.objectOutputStream.writeObject(voMember);
					}else if(protocol.length > 3) {				
						Class[] methodParamClass = new Class[] {String.class, String.class};
						Object[] methodParamObject = new Object[] {protocol[2], protocol[3]};
						
						Method method = myclass.getMethod(protocol[1], methodParamClass);
						VOMember voMember = (VOMember)method.invoke(obj, methodParamObject);
						this.objectOutputStream.writeObject(voMember);

					}else {
						Class[] methodParamClass = new Class[] {String.class};
						Object[] methodParamObject = new Object[] {protocol[2]};
						
						Method method = myclass.getMethod(protocol[1], methodParamClass);
						Vector<VOLecture> items = (Vector<VOLecture>)method.invoke(obj, methodParamObject);
						this.objectOutputStream.writeObject(items);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void finalize() {
		try {
			this.bufferedReader.close();
			this.printWriter.close();

			this.clientSocket.close();
			System.out.println("Server::finalize()");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
