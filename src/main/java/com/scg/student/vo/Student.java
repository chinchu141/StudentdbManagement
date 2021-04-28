package main.java.com.scg.student.vo;

public class Student {
	private final int sid;
	private  String name;
	private  int age;
	public Student(int sid, String name, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
	}
	public int getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return sid + "       "+ name+"           "+age;
	}
	

}