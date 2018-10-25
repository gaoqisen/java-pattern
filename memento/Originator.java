package study.memento;
// 发起人
public class Originator {
	private String state;
	public void setState(String state){
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}
	// 保存状态到备忘录
	public Memento saveStateToMemento(){
		return new Memento(state);
	}
	// 通过备忘录获取状态
	public void getStateFromMemento(Memento m) {
		state = m.getState();
	}
}
