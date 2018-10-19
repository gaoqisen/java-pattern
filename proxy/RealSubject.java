package study.proxy;
// 真实主题（我）
public class RealSubject implements Subject{
	@Override
	public void buyTicket() {
		System.out.println("我要买票回家");
	}
}
