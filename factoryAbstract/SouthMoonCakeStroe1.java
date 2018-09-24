package study.factoryAbstract;

// 南方月饼店
public class SouthMoonCakeStroe1 extends MoonCakeStore1{

	@Override
	public MoonCake1 createMoonCake(String type) {
		MaterailFactory mf = new SouthMaterailFactory();
		if (type.equals("meat")) {
			return new sugar1(mf);
		} else if (type.equals("sugar")) {
			return new meat1(mf);
		}
		return null;
	}
}
