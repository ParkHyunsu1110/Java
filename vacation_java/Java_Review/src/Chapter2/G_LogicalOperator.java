package Chapter2;

public class G_LogicalOperator {

	public static void main(String[] args) {
		//�񱳿���
		System.out.println('a' > 'b');				//false
		System.out.println(3 >= 2);					//true
		System.out.println(-1 < 0);					//true
		System.out.println(3.45 <= 2);				//false
		System.out.println(3 == 2);					//false
		System.out.println(3 != 2);					//true
		System.out.println(! (3 != 2));				//false
		//�񱳿���� ������ ����
		System.out.println("-------");
		System.out.println((3 > 2) && (3 > 4));		//false
		System.out.println((3 != 2) || (-1 > 0));	//true
		System.out.println((3 != 2) ^ (-1 > 0));	//true
	}

}
