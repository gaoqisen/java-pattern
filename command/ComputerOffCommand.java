package study.command;

public class ComputerOffCommand implements Command{
	Computer computer;
	public ComputerOffCommand(Computer com) {
		this.computer = com;
	}
	@Override
	public void execute() {
		this.computer.off();
	}

	@Override
	public void undo() {
		System.out.println("关电脑撤销准备。。。");
		this.computer.on();
	}

}
