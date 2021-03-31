import java.io.*;
import java.util.Scanner;

public class CompareFiles {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileInputStream srcStream = null;
		FileInputStream destStream = null;
		
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		String src = scanner.nextLine();
		
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		String dst = scanner.nextLine();
		
		System.out.println(src + "�� " + dst + "�� ���մϴ�.");
		try {
			srcStream = new FileInputStream(src); // ���� �Է� ��Ʈ���� ����
			destStream = new FileInputStream(dst); // ���� ��� ��Ʈ���� ����
			if (compareFile(srcStream, destStream))
				System.out.println("������ �����ϴ�.");
			else
				System.out.println("������ �ٸ��ϴ�.");
			
            if (srcStream != null) srcStream.close();
            if (destStream != null) destStream.close();
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}
		
		scanner.close();
	}

	private static boolean compareFile(FileInputStream src, FileInputStream dest) throws IOException {
		byte[] srcBuf = new byte[1024]; // 1KB ����
		byte[] destbuf = new byte[1024];  // 1KB ����
		
		int srcCount=0, destCount;
		while (true) {
			srcCount = src.read(srcBuf, 0, srcBuf.length); // src ��Ʈ������ srcBuf ũ�⸸ŭ �б�
			destCount = dest.read(destbuf, 0, destbuf.length); // dest ��Ʈ������ destBuf ũ�⸸ŭ �б�
			if (srcCount != destCount) // �о���� ����Ʈ ���� �ٸ��� ������ �ٸ� 
				return false;
			
			if(srcCount == -1)
				break; // ���� ���� ������
			
			for (int i=0; i<srcCount; i++) {
				if (srcBuf[i] != destbuf[i]) // ���� ����Ʈ�� ��
					return false;
			}
		}
		return true;
	}
}
