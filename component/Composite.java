package study.component;

import java.util.LinkedList;

public class Composite extends Component{
	private LinkedList<Component> childer; 
	public Composite(String name) {
		super(name);
		this.childer = new LinkedList<>();
	}
	
	@Override
	public void operation(int index) {
		String str = "";
		for (int i=0; i<index; i++) {
			str = str+ "    ";
		}
		LinkedList<Component> list = this.getChilder();
		System.out.println(str + name);
		for (Component c : list) {
			c.operation(index+1);
		}
	}
	public void add(Component com) {
		this.childer.add(com);
	}
	public void remove(Component com) {
		this.childer.remove(com);
	}
	public LinkedList<Component> getChilder(){
		return this.childer;
	}
	
}
