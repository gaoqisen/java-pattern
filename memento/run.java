package study.memento;

public class run {
	public static void main(String[] args) {
		Originator origin = new Originator();
		CareTaker ct = new CareTaker();
		origin.setState("状态1");
		origin.setState("状态2");
		ct.add(origin.saveStateToMemento());
		origin.setState("状态3");
		ct.add(origin.saveStateToMemento());
		origin.setState("状态4");
		
		System.out.println("当前状态为:"+ origin.getState());
		origin.getStateFromMemento(ct.getMemento(0));
		System.out.println("回到第一个状态为:"+ origin.getState());
		origin.getStateFromMemento(ct.getMemento(1));
		System.out.println("回到第二个状态为:"+ origin.getState());
		
	}
}
