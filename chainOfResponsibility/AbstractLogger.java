package study.chainOfResponsibility;
// 抽象日志
public abstract class AbstractLogger {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	public int level;
	
	public AbstractLogger nextLogger;
	// 下一个链条
	public void setNextLogger(AbstractLogger al) {
		this.nextLogger = al;
	}
	public void logMessage(int le, String message) {
		if (this.level<=le) {
			write(message);
		}
		if (this.nextLogger != null) {
			this.nextLogger.logMessage(le, message);
		}
	}
	abstract public void write(String message);
}
