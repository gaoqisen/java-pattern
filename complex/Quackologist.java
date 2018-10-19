package study.complex;

public class Quackologist implements Observer{

	@Override
	public void update(QuackObservable duck) {
		System.out.println("呱呱叫学家："+duck);
	}

}
