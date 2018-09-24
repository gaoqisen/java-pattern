package study.factory;

public class SimpleFactory {
	public MoonCake createProduct(String type) {
		MoonCake product = null;
		if (type.equals("meat")){
			product = new meat();
		} else if (type.equals("sugar")) {
			product = new sugar();
		}
		return product;
	}
}
