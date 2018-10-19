package study.complex;

import java.util.ArrayList;
import java.util.Iterator;

// 用组合模式实现一群鸭子
public class Flock implements Quackable{
	Observable ob;
	ArrayList list = new ArrayList();
	public Flock() {
		this.ob = new Observable(this);
	}
	@Override
	public void quack() {
		Iterator it = list.iterator();  // 迭代器模式
		while(it.hasNext()) {
			Quackable q = (Quackable)it.next();
			q.quack();
		}
	}
	public void add(Quackable q) {
		list.add(q);
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
