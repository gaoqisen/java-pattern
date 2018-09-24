package study.factory;
// 北方月饼店
public class NorthMoonCakeStore extends MoonCakeStore{

	@Override
	public MoonCake createMoonCake(String type) {
		if (type.equals("meat")) {
			return new NorthSytleMeatMoonCake();
		} else if (type.equals("sugar")) {
			return new NorthSytleSugarMoonCake();
		}
		return null;
	}
}
class NorthSytleMeatMoonCake extends MoonCake{
	public NorthSytleMeatMoonCake() {
		name = "北方风格的肉馅月饼";
	}
}
class NorthSytleSugarMoonCake extends MoonCake{
	public NorthSytleSugarMoonCake() {
		name = "北方风格的糖陷月饼";
	}
}