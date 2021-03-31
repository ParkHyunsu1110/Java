import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		File dir = new File("c:\\temp\\");
		File [] files = dir.listFiles(); // ���丮�� ���� ����Ʈ
		
		System.out.println(dir.getPath() + "���͸��� .txt ������ ��� �����մϴ�....");
		int count = 0;
		for(int i=0; i<files.length; i++) {
			if(!files[i].isFile()) // ������ �ƴϸ� ��������
				continue;
			
			String name = files[i].getName();
			int index = name.lastIndexOf('.'); // ���ϸ� ���ڿ����� ���� �������� �ִ� '.' �� �ε���
			if(index == -1) // ã�� �� ����
				continue;
			
			String ext = name.substring(index); // ext = ".txt" 
			if(ext.equals(".txt")) {
				System.out.println(files[i].getPath() + " ����");
				files[i].delete();
				count++;
			}
		}
		System.out.println("�� "+ count + "���� .txt ������ �����Ͽ����ϴ�.");
	}

}
