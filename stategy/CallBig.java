package study.stategy;

public class CallBig implements CallBehavior{
	@Override
	public void call() {
		System.out.println("特别大声的叫");
	}
}
