package study.builder;
// 项目接口
public interface Item {
	public String name();
	public Packing packing();
	public float price();
}
// 汉堡使用包装纸包装抽象类
abstract class Burger implements Item{
	public Packing packing(){
		return new Wrapper();
	};
	public abstract float price(); 
}
// 冷饮抽象类
abstract class ColdDrink implements Item{
	public Packing packing() {
		return new Bottle();
	}
	public abstract float price();
}
// 蔬菜汉堡
class VegBurger extends Burger{
	@Override
	public String name() {
		return "蔬菜汉堡";
	}
	@Override
	public float price() {
		return 18.8f;
	}
}
// 鸡肉汉堡
class ChickenBurger extends Burger{
	@Override
	public String name() {
		return "鸡肉汉堡";
	}
	@Override
	public float price() {
		return 28.8f;
	}
}
// 可口可乐
class Coke extends ColdDrink{
	@Override
	public String name() {
		return "可口可乐";
	}
	@Override
	public float price() {
		return 5.5f;
	}
}
// 百事可乐
class Pepsi extends ColdDrink{
	@Override
	public String name() {
		return "百事可乐";
	}
	@Override
	public float price() {
		return 5.6f;
	}
}