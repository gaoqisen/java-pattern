package study.stategy;

public abstract class animal {
	private String name;
	private int age;
	
	FlyBehavior flyBehavior;  // 让所有的动物都继承这个行为
	CallBehavior callBehavior;
	
	public  abstract void display();  // 动物的外表、抽象方法
	
	public void performFly() {  // 执行飞行
		flyBehavior.fly();
	}
	public void performCall() { // 执行叫喊
		callBehavior.call(); 
	}
	public void setFlyBehavior(FlyBehavior fly){   // 动态的设置飞行的实现类
		this.flyBehavior = fly;
	}
	public void setCallBehavior(CallBehavior call){
		this.callBehavior = call;
	}
}
