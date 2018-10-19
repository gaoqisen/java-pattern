package study.complex;
// 鸭子模拟器
public class DuckSimulator {
	public void simulate() {  // 模拟
		Quackable mallardDuck =new QuackCounter( new MallardDurk());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable goose = new GooseAdapter(new Goose());  // 一只鹅
		sumulate(mallardDuck);
		sumulate(redheadDuck);
		sumulate(duckCall);
		sumulate(rubberDuck);
		sumulate(goose);
		System.out.println("鸭子的数量为:"+QuackCounter.getNum());
	}
	private void sumulate(Quackable qa) {
		qa.quack();
	}
	// 重写构造方法
	public void simulate(AbstractDuckFactory adf) {
		Quackable mallardDuck =adf.createMallardDuck();
		Quackable redheadDuck = adf.createRedheadDuck();
		Quackable duckCall = adf.createDuckCall();
		Quackable rubberDuck = adf.createRubberDuck();
		Quackable goose = new GooseAdapter(new Goose());  // 一只鹅
		
		Flock fock = new Flock();  // 一群乱七八糟的鸭子
		fock.add(redheadDuck);
		fock.add(rubberDuck);
		fock.add(duckCall);
		fock.add(mallardDuck);
		
		Flock focks = new Flock();
		Quackable redheadDuck1 = adf.createRedheadDuck();  //一群红头鸭子
		Quackable redheadDuck2 = adf.createRedheadDuck();
		Quackable redheadDuck3 = adf.createRedheadDuck();
		Quackable redheadDuck4 = adf.createRedheadDuck();
		
		focks.add(redheadDuck4);
		focks.add(redheadDuck3);
		focks.add(redheadDuck2);
		focks.add(redheadDuck1);
		
		System.out.println("红头鸭子打头");
		sumulate(focks);
		System.out.println("乱七八糟的鸭子来了");
		sumulate(fock);
		System.out.println("鸭子的数量为:"+QuackCounter.getNum());
		
		Quackologist ql = new Quackologist();
		fock.registerObserver(ql);
		sumulate(fock);
		System.out.println("鸭子的数量为:"+QuackCounter.getNum());
	}
}
