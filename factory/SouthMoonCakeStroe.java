package study.factory;
// 南方月饼店
public class SouthMoonCakeStroe extends MoonCakeStore{

	@Override
	public MoonCake createMoonCake(String type) {
		if (type.equals("meat")) {
			return new SouthSytleMeatMoonCake();
		} else if (type.equals("sugar")) {
			return new SouthSytleSugarMoonCake();
		}
		return null;
	}
}
class SouthSytleMeatMoonCake extends MoonCake{
	public SouthSytleMeatMoonCake() {
		name ="南方风格的肉馅月饼";
	}
}
class SouthSytleSugarMoonCake extends MoonCake{
	public SouthSytleSugarMoonCake() {
		name = "南方风格的糖陷月饼";
	}
}