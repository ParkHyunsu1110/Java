package java_2020_11_23_1;
public class Choi extends Student {
	protected String SSN;
	public Choi() {
		this.name = "ChoiSimCheong";
		this.age = 15;
		this.code = 1221;
		this.school = "��ü���б�";
		this.SSN = "060229-3000000";
	}
	public void show() { System.out.println("�̸� : " + name + "\n" + "���� : " + age + "\n" + "�й� : " + code + "\n" + "�б� : " + school + "\n" + "�ֹι�ȣ : " + SSN); }
	@Override
	public void Student() {}
}
