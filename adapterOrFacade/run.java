package study.adapterOrFacade;

public class run {
	public static void main(String[] args) {
		// 适配器模式
		SocketThree st = new SocketThreeImpl();
		st.chargeThree();
		// 通过转换器将三孔插座转换为两孔插座
		SocketTwo stwo = new SocketAdapter(st);
		stwo.chargeTwo();
		
		// 外观模式
		TV tv = new TV();
		Light light = new Light();
		Stove stove = new Stove();
		// 创建大插板， 统一开关
		FacadeSocket fs = new FacadeSocket(tv, light,stove);
		fs.on();
		fs.off();
	}
}
