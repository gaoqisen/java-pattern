package study.adapterOrFacade;
// 插座适配器 将三孔插座转换为二孔插座， 看着像二孔，但是实际上还是三孔
public class SocketAdapter implements SocketTwo{
	SocketThree socketThree;
	public SocketAdapter(SocketThree socketThree) {
		this.socketThree = socketThree;
	}
	@Override
	public void chargeTwo() {
		System.out.println("转换后的两孔插座");
		this.socketThree.chargeThree();
	}
}
