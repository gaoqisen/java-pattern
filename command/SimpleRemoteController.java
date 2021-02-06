package study.command;
// 简单远程控制
public class SimpleRemoteController {
	Command command;
	Command undoCommand;
	public SimpleRemoteController(){};
	// 利用有参构造器初始化命令
	public void setCommand(Command command) {
		this.command = command;
	}
	public void start() {
		command.execute();
		this.undoCommand = this.command;
	}
	public void undo() {
		this.undoCommand.undo();
	}
}
