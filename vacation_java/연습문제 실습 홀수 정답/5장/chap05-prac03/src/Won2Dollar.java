import java.util.Scanner;
abstract class Converter {
	abstract protected double convert(double src); // �߻� �޼ҵ�
	abstract protected String srcString(); // �߻� �޼ҵ�
	abstract protected String destString(); // �߻� �޼ҵ�
	protected double ratio; // ����
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(srcString() + "�� " + destString() + "�� �ٲߴϴ�.");
		System.out.print(srcString() + "�� �Է��ϼ���>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("��ȯ ���: " + res + destString() + "�Դϴ�");
		scanner.close();
	}
}

class Won2Dollar extends Converter {
	public Won2Dollar(double ratio) {
		this.ratio = ratio;
	}
	
	@Override
	protected double convert(double src) {
		return src/ratio;
	}

	@Override
	protected String srcString() { return "��"; }

	@Override
	protected String destString() { return "�޷�"; }
	
	public static void main(String args[]) {
		Won2Dollar toDollar = new Won2Dollar(1200); // 1�޷��� 1200��
		toDollar.run();
	}
}