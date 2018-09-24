package study.factoryAbstract;

// 月饼店抽象类	
public abstract class MoonCakeStore1 {
	public MoonCake1 orderMoonCake(String type) {
		MoonCake1 mc;
		mc = createMoonCake(type);
		mc.kenad();
		mc.prepare();
		return mc;
	}
	// 抽象的工厂方法
	public abstract MoonCake1 createMoonCake(String type);
}
