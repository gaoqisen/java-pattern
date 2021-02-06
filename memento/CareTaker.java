package study.memento;

import java.util.ArrayList;
import java.util.List;

// 守护者
public class CareTaker {
	private List<Memento> list = new ArrayList<Memento>();
	
	public void add(Memento m) {
		list.add(m);
	}
	public Memento getMemento(int i) {
		return list.get(i);
	}
}
