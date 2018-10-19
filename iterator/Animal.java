package study.iterator;
// 动物类
public class Animal {
	String name;
	int age;
	String description;
	public Animal(String name, int age, String des) {
		this.name = name;
		this.age = age;
		this.description = des;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getDescription() {
		return description;
	}
}
