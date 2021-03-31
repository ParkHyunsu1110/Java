import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileSender {
	public static void main(String[] args) {
		FileInputStream fin = null; // BufferedInputStream
		File f = null;
		BufferedOutputStream fout = null;
		Scanner scanner  = new Scanner(System.in);
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999); // Ŭ���̾�Ʈ ���� ����
			System.out.print("���� ���� �̸��� �Է��ϼ���>>");
			String fileName = scanner.next();
			f = new File(fileName);
			long length = f.length();
			fin = new FileInputStream(f); // Ű����κ����� �Է� ��Ʈ��
			fout = new BufferedOutputStream(socket.getOutputStream()); // �������� ��� ��Ʈ��
			
			byte[] fname = f.getName().getBytes(); // ��θ� ������ ���� �̸�
			int nameSize = fname.length;
			fout.write(Command.FILE_NAME); // FILE_NAME ��� ����
			sentInt(fout, nameSize);  // ���� �̸� ũ�� ����
			fout.write(fname); // ���� ���� �̸� ����
			
			fout.write(Command.FILE_SIZE); // FILE_SIZE ��� ����
			sentInt(fout, (int)length);
			sentInt(fout, (int)(length >>> 32));
			
			fout.write(Command.SEND_BEGIN); // SEND_BEGIN ��� ����
			int count = 0;
			byte b[] = new byte[512];
			while (length > 0) {
				int numRead = fin.read(b,0,b.length);
				if (numRead <= 0) { 
					if (length > 0) { // �� �̻� ���� ���� ���µ� ���� ���� ũ�⸸ŭ �� ���� ���
						System.out.println("���� ������ �߻��߽��ϴ�. ���� ����Ʈ: " + count + " ���� ����Ʈ:" + length);					
						break;
					} 
				} else {
					fout.write(b, 0, numRead);
					length -= numRead;
					fout.flush();
					count += numRead;
				}
			}
			fout.write(Command.SEND_END); // SEND_END ��� ����
			fout.flush();
			fin.close();
			socket.close(); // Ŭ���̾�Ʈ ���� �ݱ�
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ���� �� ������ �߻��߽��ϴ�.");
		}
	}

	private static void sentInt(BufferedOutputStream fout, int value) throws IOException {
		fout.write(value & 0x000000ff);
		fout.write((value & 0x0000ff00)>>8);
		fout.write((value & 0x00ff0000)>>16);
		fout.write((value & 0xff000000)>>24);
	}
}
