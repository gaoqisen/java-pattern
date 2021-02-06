package study.command;
// 遥控器
public class RemoteController {
	Command[] onCommands;
	Command[] offCommands;
	public RemoteController () {
		this.onCommands = new Command[2];
		this.offCommands = new Command[2];
	}
	public void setCommand(int index, Command on,Command off) {
		this.onCommands[index] = on;
		this.offCommands[index] = off;
	}
	public void on(int index) {
		this.onCommands[index].execute();
	}
	public void off(int index) {
		this.offCommands[index].execute();
	}
}
