package study.command;
// 宏命令
public class MacroCommand implements Command{
	Command[] commands;
	public MacroCommand(Command[] command){
		this.commands = command;
	}
	@Override
	public void execute() {
		for(Command c : this.commands ){
			c.execute();
		}
	}

	@Override
	public void undo() {
		for(Command c : this.commands ){
			c.undo();
		}
	}

}
