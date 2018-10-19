package study.adapterOrFacade;
// 三孔插座
public interface SocketThree {
	public void chargeThree();
}
class SocketThreeImpl implements SocketThree{

	@Override
	public void chargeThree() {
		System.out.println("三孔插座");
	}
}