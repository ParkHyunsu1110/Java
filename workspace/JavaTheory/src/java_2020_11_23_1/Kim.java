package java_2020_11_23_1;
public class Kim extends Student{
	public Kim() {
		this.name = "KimGilDong";
		this.age = 17;
		this.code = 17009;
		this.school = "자바고등학교";
	}
	public void show() { System.out.println("이름 : " + name + "\n" + "나이 : " + age + "\n" + "학번 : " + code + "\n" + "학교 : " + school); }
	@Override
	public void Student() {}
}