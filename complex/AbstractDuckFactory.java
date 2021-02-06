package study.complex;
// 鸭叫抽象工厂
public abstract class AbstractDuckFactory {
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}

// 鸭叫工厂实现鸭叫抽象工厂
class DuckFactory extends AbstractDuckFactory{
	@Override
	public Quackable createMallardDuck() {
		return new MallardDurk();
	}
	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}
	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}
	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}
}

// 统计鸭子工厂继承鸭子抽象工厂
class CountingDuckFactory extends AbstractDuckFactory{
	@Override
	public Quackable createMallardDuck() {
		// 先用叫声计数装饰着将quackable装饰起来
		return new QuackCounter(new MallardDurk());
	}
	@Override
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}
	@Override
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}
	@Override
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}
}