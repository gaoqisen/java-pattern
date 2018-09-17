package study.observer;

import java.util.Observable;
import java.util.Observer;

public class UserJDK implements Observer{  // 实现java自带的观察者
	Observable observable;
	private String name = "jdk";
	private String content;

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof BankOffcialAccounts) {
			BankOffcialAccounts boa = (BankOffcialAccounts)o;
			this.content = boa.getContent();
			System.out.println(name+"接收到了"+content);
		}
	}
	public UserJDK(Observable o) {
		this.observable = o;
		observable.addObserver(this);
	}
	
}
