package java_2020_11_23_1;
public class Choi extends Student {
	protected String SSN;
	public Choi() {
		this.name = "ChoiSimCheong";
		this.age = 15;
		this.code = 1221;
		this.school = "객체중학교";
		this.SSN = "060229-3000000";
	}
	public void show() { System.out.println("이름 : " + name + "\n" + "나이 : " + age + "\n" + "학번 : " + code + "\n" + "학교 : " + school + "\n" + "주민번호 : " + SSN); }
	@Override
	public void Student() {}
}
