package study.factory;

public class MoonCake {
	public String name;
	public void kenad() {
		System.out.println("揉面粉");
	}
	public String getName() {
		return name;
	}
}
// 糖陷月饼
class sugar extends MoonCake{
	public sugar(){
		System.out.println("糖陷");
	}
}
// 肉陷月饼
class meat extends MoonCake {
	public meat() {
		System.out.println("肉馅");
	}
}

