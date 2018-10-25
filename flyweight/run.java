package study.flyweight;

public class run {
	public static void main(String[] args) {
		CarKeeper ck = new CarKeeper();
		Car car1 = ck.getCar("奥迪");
		car1.drive();
		Car car2 = ck.getCar("宝马");
		car2.drive();
		Car car3 = ck.getCar("雷克萨斯");
		car3.drive();
		Car car4 = ck.getCar("雷克萨斯");
		car4.drive();
		Car car5 = ck.getCar("宝马");
		car5.drive();
		Car car6 = ck.getCar("奥迪");
		car6.drive();
	}
}
