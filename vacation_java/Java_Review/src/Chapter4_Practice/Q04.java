package Chapter4_Practice;
/*
 * ���α׷��� : ���簢�� ǥ���ϱ�
 * */
public class Q04 {
	private int x, y, width, height;
	public Q04(int x,int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public int square() { return width*height; }
	public boolean contain(Q04 r) {
		if(r.x > this.x && r.x+r.width < this.x+this.width && r.y>this.y && r.y+r.height < this.y+this.height) return true;
		else return false;
	}
	void show() {System.out.println("(" + x + "," + y + ")���� ũ�Ⱑ " + width + "X" + height + "�� �簢��");}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q04 r = new Q04(2,2,8,7);
		Q04 s = new Q04(5,5,6,6);
		Q04 t = new Q04(1,1,10,10);
		
		r.show();
		System.out.println("s�� ������ " + s.square() + " �Դϴ�.");
		if(t.contain(r)) System.out.println("t�� r�� �����մϴ�.");
		if(t.contain(s)) System.out.println("t�� s�� �����մϴ�.");
	}

}
