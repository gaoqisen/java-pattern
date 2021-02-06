package study.complex;
// 鸭叫能力接口
public interface Quackable extends QuackObservable{
	public void quack();  // 呱呱叫
}
// 绿头鸭实现鸭叫能力接口
class MallardDurk implements Quackable{
	Observable ob;
	@Override
	public void quack() {
		System.out.println("绿头鸭嘎嘎叫");
		this.ob = new Observable(this);
	}
	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}
	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}
// 红头鸭也实现鸭叫能力接口
class RedheadDuck implements Quackable{
	Observable ob;
	@Override
	public void quack() {
		System.out.println("红头鸭嘎嘎叫");
		this.ob = new Observable(this);
	}
	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}
	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}
//鸭鸣器也实现了鸭叫能力接口
class DuckCall implements Quackable{
	Observable ob;
	@Override
	public void quack() {
		System.out.println("鸭鸣器嘎嘎叫");
		this.ob = new Observable(this);
	}

	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}
// 橡皮鸭也实现了鸭叫能力接口
class RubberDuck implements Quackable{
	Observable ob;
	@Override
	public void quack() {
		System.out.println("橡皮鸭嘎嘎叫");
		this.ob = new Observable(this);
	}
	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}
	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}

// 鹅
class Goose{
	public void honk() {
		System.out.println("鹅咯咯叫");
	}
}
// 用适配器模式将鹅适配为鸭子
class GooseAdapter implements Quackable{
	Observable ob;
	Goose goose;
	public GooseAdapter(Goose goose) {
		this.ob = new Observable(this);
		this.goose = goose;
	}
	@Override
	public void quack() {
		this.goose.honk();
	}
	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}
	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}
// 利用装饰者模式，在不改变原来鸭子类的情况下给鸭子添加计数功能
class QuackCounter implements Quackable{
	Observable ob;
	Quackable duck;
	static int num;
	public QuackCounter (Quackable quack) {
		this.ob = new Observable(quack);
		this.duck = quack;
	}
	@Override
	public void quack() {
		this.duck.quack();
		num++;
	}
	public static int getNum() {
		return num;
	}
	@Override
	public void registerObserver(Observer observer) {
		this.ob.registerObserver(observer);
	}
	@Override
	public void notifyObservers() {
		this.ob.notifyObservers();
	}
}