package study.chainOfResponsibility;
// 打印日志
public class ConsoleLogger extends AbstractLogger{
	public ConsoleLogger(int le) {
		this.level = le;
	}
	@Override
	public void write(String message) {
		System.out.println("打印日志:"+message);
	}
}

class ErrorLogger extends AbstractLogger{
	public ErrorLogger(int le) {
		this.level = le;
	}
	@Override
	public void write(String message) {
		System.out.println("异常日志:"+message);
	}
}
// 文件日志
class FileLogger extends AbstractLogger{
	public FileLogger(int le) {
		this.level = le;
	}
	@Override
	public void write(String message) {
		System.out.println("文件日志:" + message);
	}
}