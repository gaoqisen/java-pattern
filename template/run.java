package study.template;

public class run {
	public static void main(String agrs[]) {
		ChineseCabbage cc = new ChineseCabbage();
		cc.prepareCooking();
		System.out.println("+++++++++");
		lettuce lt = new lettuce();
		lt.prepareCooking();
	}
}
