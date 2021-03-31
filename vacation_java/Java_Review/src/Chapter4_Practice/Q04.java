package Chapter4_Practice;
/*
 * 프로그램명 : 직사각형 표현하기
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
	void show() {System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "X" + height + "인 사각형");}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q04 r = new Q04(2,2,8,7);
		Q04 s = new Q04(5,5,6,6);
		Q04 t = new Q04(1,1,10,10);
		
		r.show();
		System.out.println("s의 면적은 " + s.square() + " 입니다.");
		if(t.contain(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contain(s)) System.out.println("t는 s를 포함합니다.");
	}

}
