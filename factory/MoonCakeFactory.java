package study.factory;

public class MoonCakeFactory {
	SimpleFactory factory;
	public MoonCakeFactory(SimpleFactory factory) {
		this.factory = factory;
	}
	public MoonCake orderMoonCake(String type) {
		MoonCake product = factory.createProduct(type);
		return product;
	}
}
