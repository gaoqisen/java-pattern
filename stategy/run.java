package study.stategy;

public class run {
	public static void main(String args[]) {
		animal dw = new DogModle();
		dw.performFly();  // 默认飞行
		dw.performCall();  // 默认叫喊
		dw.setFlyBehavior(new FlyRockets());  //动态绑定飞行行为
		dw.performFly();   // 更改之后的飞行方式
	}
}
