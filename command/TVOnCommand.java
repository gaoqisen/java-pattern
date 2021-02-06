package study.command;
// 开电视
public class TVOnCommand implements Command{
	TV tv;
	public TVOnCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.on();
	}

	@Override
	public void undo() {
		System.out.println("开电视撤销准备。。。");
		tv.off();
	}

}
