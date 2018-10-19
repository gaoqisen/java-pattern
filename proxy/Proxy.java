package study.proxy;
// 代理买票（黄牛）
public class Proxy implements Subject{

	@Override
	public void buyTicket() {
		RealSubject rs = new RealSubject();
		rs.buyTicket();
		this.compterTicket();
	}
	// 不公开的买票方式，通过电脑买票
	private void compterTicket() {
		System.out.println("黄牛进行买票");
	}
}
