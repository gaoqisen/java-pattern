package study.adapterOrFacade;
// 两孔插座
public interface SocketTwo {
	public void chargeTwo();
}
class SocketTwoImpl implements SocketTwo{

	@Override
	public void chargeTwo() {
		System.out.println("两孔插座");
	}
	
}