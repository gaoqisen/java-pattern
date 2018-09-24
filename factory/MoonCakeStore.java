package study.factory;
// 月饼店
public abstract class MoonCakeStore {
	public MoonCake orderMoonCake(String type) {
		MoonCake mc;
		mc = createMoonCake(type);
		mc.kenad();
		return mc;
	}
	// 抽象的工厂方法
	public abstract MoonCake createMoonCake(String type);
}
