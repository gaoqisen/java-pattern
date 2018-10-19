package study.command;

public class run {
	public static void main(String[] args) {
		// 创建远程控制器
		SimpleRemoteController simpleRemoteController = new SimpleRemoteController();
		TV tv = new TV();  // 创建电视
		
		TVOnCommand tvon = new TVOnCommand(tv);  // 创建关电视命令
		simpleRemoteController.setCommand(tvon);  // 通过远程控制器设置关电视的命令
		simpleRemoteController.start();  // 按开始按钮
		simpleRemoteController.undo();
		
		TVOffCommand tvoff = new TVOffCommand(tv);  // 创建关电视命令
		simpleRemoteController.setCommand(tvoff);  // 通过远程控制器设置关电视的命令
		simpleRemoteController.start();  // 按开始按钮
		simpleRemoteController.undo();
		
		System.out.println("++++++++++++++++++++++++");
		Computer computer = new Computer();
		RemoteController remoteController = new RemoteController();
		ComputerOffCommand coffc = new ComputerOffCommand(computer);
		ComputerOnCommand conc = new ComputerOnCommand(computer);
		// 实现宏命令
		Command[] on = {tvon, conc};
		Command[] off = {tvoff,coffc};
		MacroCommand onmc = new MacroCommand(on);
		MacroCommand offmc = new MacroCommand(off);
		remoteController.setCommand(0, onmc, offmc);
		System.out.println("宏命令结束");
		remoteController.on(0);
		System.out.println("单独执行");
		remoteController.off(0);
	}
}
