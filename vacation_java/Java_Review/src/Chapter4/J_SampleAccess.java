package Chapter4;
/*
 * 프로그램명 : 멤버의 접근 지정자
 * */
class Sample{
	public int a;
	private int b;
	int c;
}
public class J_SampleAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample sample = new Sample();
		sample.a = 10;
		//sample.b = 10;
		sample.c = 10;
	}

}
