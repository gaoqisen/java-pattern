package study.stategy;

public class DogModle extends animal{
	public DogModle() {  // 狗狗的构造器
		callBehavior = new CallBig();   // 大声叫
		flyBehavior = new FlyNoWay();   // 默认不会飞
	}
	@Override
	public void display() {
		System.out.println("模型狗狗的造型");
	}
	
}
