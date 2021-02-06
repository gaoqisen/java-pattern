package study.command;

public class ComputerOnCommand implements Command{
	Computer computer;
	public ComputerOnCommand(Computer computer) {
		this.computer = computer;
	}
	@Override
	public void execute() {
		this.computer.on();
	}

	@Override
	public void undo() {
		System.out.println("开电脑撤销准备。。。");
		this.computer.off();
	}

}
