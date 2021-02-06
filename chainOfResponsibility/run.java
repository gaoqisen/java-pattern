package study.chainOfResponsibility;

public class run {
	public static void main(String[] args) {
		AbstractLogger al = Chain.getChainOfLogger();
		al.logMessage(AbstractLogger.INFO, "文件信息");
		System.out.println("");
		al.logMessage(AbstractLogger.DEBUG, "debug信息");
		System.out.println("");
		al.logMessage(AbstractLogger.ERROR, "异常信息");
	}
}
