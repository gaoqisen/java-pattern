package study.command;

public class TVOffCommand implements Command{
	TV tv;
	public TVOffCommand(TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.off();
	}

	@Override
	public void undo() {
		System.out.println("关电视撤销准备。。。");
		tv.on();
	}

}
