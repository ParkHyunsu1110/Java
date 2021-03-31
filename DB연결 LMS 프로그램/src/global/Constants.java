package global;

public class Constants {
	public static enum ELecturePanel {
		serialVersionUID("1"),
		ID("���¹�ȣ"),
		name("���¸�"),
		professorName("��米��"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ESearchPanel {
		name("���¸�"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private ESearchPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		ID("���¹�ȣ"),
		name("���¸�"),
		professorName("��米��"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EMovePanel {
		serialVersionUID("1"),
		Left("<"),
		Right(">"),
		Rightpass("�ٷ� ��û�ϱ�     "),
		Leftpass("<<"),
		Basket("å���濡 ���   "),
		Result("��û�ϱ�    "),
		LeftButton("LeftButton"),
		RightButton("RightButton"),
		RightpassButton("RightpassButton"),
		LeftpassButton("LeftpassButton");
		
		private String value;
		private EMovePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EButton {
		serialVersionUID("1"),
		Login("�α���   "),
		Logout("�α׾ƿ�   "),
		Mypage("����������     "),
		Inform("ȸ������    "),
		Grade("��������    "),
		Rewirte("�����ϱ�     "),
		Okay("Ȯ��  "),
		Change("��������    "),
		Check("������  "),
		Reset("Reset      "),
		Find("ID/PW ã��        "),
		PW("PW ã��   "),
		ID("ID ã��   "),
		New("ȸ������   ");
		
		private String value;
		private EButton(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
