package Chapter4;
/*
 * ���α׷��� : �������� �߻�
 * */
public class I_Garbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("Good");
		String b = new String("bad");
		String c = new String("normal");
		String d,e;
		a = null;
		d = c;
		c = null;
		System.out.print(a + "," + b + "," + c + "," + d + ",");
	}

}
