package study.component;
// 叶子
public class Leaf extends Component{

	public Leaf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operation(int index) {
		String str = "";
		for (int i=0; i<index; i++) {
			str = str+ "    ";
		}
		System.out.println(str + name);
	}
}
