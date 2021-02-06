package study.stategy;

public class CallNoWay implements CallBehavior{

	@Override
	public void call() {
		System.out.println("不会叫");
	}

}
