package study.composite;

public class Animal extends PetShopComponent{
	private String name;
	private String des;
	private int age;
	
	public Animal(String name, String des, int age ){
		this.name = name;
		this.des = des;
		this.age = age;
	}
	public String getName(){  //获取名字
		return this.name;
	}
	public String getDes() { // 获取详情
		return this.des;
	}
	public int getAge() { // 获取年龄
		return this.age;
	}
	public void print() { // 输出
		System.out.println("名字为："+name+"   年龄为："+age + "  介绍："+des);
	}
}
