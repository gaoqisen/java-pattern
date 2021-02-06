package study.chainOfResponsibility;

public class Chain {
	public static AbstractLogger getChainOfLogger() {
		AbstractLogger el = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fl = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger cl = new ConsoleLogger(AbstractLogger.INFO);
		el.setNextLogger(fl);
		fl.setNextLogger(cl);
		return el;
	}
}
