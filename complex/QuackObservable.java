package study.complex;

import java.util.ArrayList;
import java.util.Iterator;
// 鸭叫观察者接口
public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
interface Observer {
	public void update(QuackObservable duck);
}
// 观察者辅助类
class Observable implements QuackObservable{
	ArrayList observers = new ArrayList();
	QuackObservable duck;
	public  Observable(QuackObservable q){
		this.duck = q;
	}
	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator it = this.observers.iterator();
		while (it.hasNext()) {
			Observer ob = (Observer)it.next();
			ob.update(duck);
		}
	}
	
}