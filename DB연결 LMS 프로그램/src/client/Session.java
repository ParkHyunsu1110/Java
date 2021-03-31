package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

import valueobject.VOLecture;
import valueobject.VOMember;

public class Session {

	private Socket socket;
	private InputStream inputStream;
	private BufferedReader bufferedReader;
	private ObjectInputStream objectInputStream;
	private PrintWriter printWriter;

	public Session(Socket socket) {
		this.socket = socket;
	}

	public void initialize() {
		try {
			this.inputStream = this.socket.getInputStream();
			this.objectInputStream = new ObjectInputStream(this.inputStream);
			this.bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
			this.printWriter = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public VOMember getMemberObject() {
		try {
			VOMember voMember = (VOMember)objectInputStream.readObject();
			return voMember;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<VOMember> getMemberAll() {
		try {
			Vector<VOMember> voMember = (Vector<VOMember>)objectInputStream.readObject();
			return voMember;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<VOLecture> getLectureObject() {
		try {
			Vector<VOLecture> voLecture = (Vector<VOLecture>)objectInputStream.readObject();
			return voLecture;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void sendProtocol(String string) {
		this.printWriter.println(string);
		this.printWriter.flush();
	}
	
	public void finalize() {
		try {
			this.printWriter.close();
			this.bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
