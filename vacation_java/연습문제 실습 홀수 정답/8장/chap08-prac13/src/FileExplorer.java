import java.io.File;
import java.util.Scanner;

public class FileExplorer {
	private File currentDir = null;
	private File subFiles [] = null;
	
	public FileExplorer(String dirName) {
		currentDir = new File(dirName);
	}

	private void showSubDirtories() {
		System.out.println("\t[" + currentDir.getPath() + "]");
		subFiles = currentDir.listFiles();
		for(File f : subFiles) {
			System.out.print(((f.isFile())?"file":"dir"));
			System.out.printf("%-15s", "\t\t" + f.length() + "����Ʈ");
			System.out.println("\t\t" + f.getName());
		}		
	}
	
	private boolean contains(String filename) {
		for(File f : subFiles) {
			if(f.getName().equalsIgnoreCase(filename))
				return true;
		}
		return false;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***** ���� Ž�����Դϴ�. *****");
		showSubDirtories();
		
		while(true) {
			System.out.print(">>");
			String command = scanner.nextLine().trim(); // �� ������ �а� �յڿ� �Է��� ��ĭ �����
			if(command.equals("�׸�"))
				break; // ���α׷� ����
			if(command.equals("..")) {
				String s = currentDir.getParent();
				if(s == null) // s�� null�̸�, currentDir�� ���� �ֻ��� ���͸��� �θ� ���͸��� ����
					continue;
				else { 					
					currentDir = new File(currentDir.getParent());
					showSubDirtories();
				}

			}
			else { // command�� ������丮�̸�
				if(contains(command)) { // ���� ���͸��� �����̳� ������丮���
					if(new File(currentDir, command).isDirectory()) { // ���͸����
						currentDir = new File(currentDir, command);
						showSubDirtories();
					}
					else { // ������ ���
						System.out.println("\t���͸��� �ƴմϴ�.!");
					}
				}
			}
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		FileExplorer fe = new FileExplorer("c:\\");
		fe.run();
	}

}
