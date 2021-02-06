package study.proxy;

public class run {
	public static void main(String[] args) {
		// 调用者完全不知道是谁买票，只知道是一个黄牛保护目标
		Subject sb =new Proxy();
		sb.buyTicket();
	}
}
