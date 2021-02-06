package study.stategy;

public class Dog extends animal{
	
	public Dog() {  // 狗狗的构造器
		callBehavior = new CallBig();   // 大声叫
		flyBehavior = new FlyNoWay();  // 
	}
	@Override
	public void display() {  // animal抽象方法需要实现的
		System.out.println("狗狗的外观显示");
	}
	
}
