package global;

public class Constants {
	public static enum ELecturePanel {
		serialVersionUID("1"),
		ID("강좌번호"),
		name("강좌명"),
		professorName("담당교수"),
		credit("학점"),
		time("시간");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ESearchPanel {
		name("강좌명"),
		credit("학점"),
		time("시간");
		
		private String value;
		private ESearchPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		ID("강좌번호"),
		name("강좌명"),
		professorName("담당교수"),
		credit("학점"),
		time("시간");
		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EMovePanel {
		serialVersionUID("1"),
		Left("<"),
		Right(">"),
		Rightpass("바로 신청하기     "),
		Leftpass("<<"),
		Basket("책가방에 담기   "),
		Result("신청하기    "),
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
		Login("로그인   "),
		Logout("로그아웃   "),
		Mypage("마이페이지     "),
		Inform("회원정보    "),
		Grade("성적관리    "),
		Rewirte("수정하기     "),
		Okay("확인  "),
		Change("사진변경    "),
		Check("강의평가  "),
		Reset("Reset      "),
		Find("ID/PW 찾기        "),
		PW("PW 찾기   "),
		ID("ID 찾기   "),
		New("회원가입   ");
		
		private String value;
		private EButton(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
