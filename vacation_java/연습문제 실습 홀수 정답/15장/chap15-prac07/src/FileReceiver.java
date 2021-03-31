import java.io.*;
import java.net.*;

public class FileReceiver {
	public static void main(String[] args) {
		BufferedInputStream fin = null;
		BufferedOutputStream fout = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999); // ���� ���� ����
			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
			System.out.println("�����");
			fin = new BufferedInputStream(socket.getInputStream()); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
			int cmd;
			String fileName = null;
			long length=0;
			
			cmd = fin.read();
			if (cmd == Command.FILE_NAME) { // FILE_NAME ��� ����
				int nameSize = receiveInt(fin); // ���� �̸� ũ��
				System.out.println("���۹��� ���� �̸� ���� :" + nameSize);
				byte fname[] = new byte[nameSize];
				fin.read(fname); 
				fileName = new String(fname);
				System.out.println("���۹��� ���� �̸�:" + fileName);
				System.out.println("������ ���� �̸�:" + "copy_" + fileName);
				fout = new BufferedOutputStream(new FileOutputStream("copy_" + fileName));
			} else {
				System.out.println("��� ���� ����" + cmd);
				socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
				listener.close(); // ���� ���� �ݱ�
				return;
			}
			cmd = fin.read();
			if (cmd == Command.FILE_SIZE) { // FILE_SIZE ��� ����
				int lenghLow = receiveInt(fin); // ���� ũ���� ���� 4����Ʈ
				int lenghHigh = receiveInt(fin); // ���� ũ���� ���� 4����Ʈ
				length = lenghHigh;
				length <<= 32; // ���� ����Ʈ�� ����� ���� 32��Ʈ ����Ʈ
				length += lenghLow; // ���� 4 ����Ʈ ���ϱ�
				System.out.println("���۹��� ���� ũ��:" + length);
			} else {
				System.out.println("��� ���� ����" + cmd);
				if (fout != null)
					fout.close();
				socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
				listener.close(); // ���� ���� �ݱ�
				return;
			}
			cmd = fin.read();
			if (cmd == Command.SEND_BEGIN) {
				int numberToRead;
				while (length >0) {
					byte b[] = new byte[2048];
					if (length < b.length) 
						numberToRead = (int)length;
					else
						numberToRead = b.length;
					int numRead = fin.read(b, 0, numberToRead);
					if (numRead <= 0) { 
						if (length > 0) { // �� �̻� ���� ���� ���µ� ���� ���� ũ�⸸ŭ �� ���� ���
							System.out.println("���� ������ �߻��߽��ϴ�. ���� ����Ʈ: " + numRead + " ���� ����Ʈ:" + length);
							break;
						}
					} else {
						System.out.print("."); // ���� ���� ǥ�� 
						fout.write(b, 0, numRead);
						length -= numRead;
					}
				}
				cmd = fin.read();
				if (cmd == Command.SEND_END) { // SEND_END ���
					System.out.println("\n���� ���� ����. ���� �j���� ����Ǿ����ϴ�.");
				} else {
					System.out.println("\n��� ���� ����" + cmd);
				}
				if (fout != null)
					fout.close();
				socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
				listener.close(); // ���� ���� �ݱ�
			}
		} catch (IOException e) {
			System.out.println("���� ���� �� ������ �߻��߽��ϴ�.");
		}
	}

	private static int receiveInt(BufferedInputStream fin) throws IOException {
		int value;
		value = fin.read();
		value |= fin.read() << 8;
		value |= fin.read() << 16;
		value |= fin.read() << 24;
		return value;
	}

}
