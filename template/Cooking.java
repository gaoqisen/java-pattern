package study.template;

public abstract class Cooking {
	// 准备烹饪
	public void prepareCooking() {
		WashingVegetables();
		addVegetables();
		addSalt();
		// 根据菜的样式判断是否加辣椒
		if (isChiliHooks()) {
			addChili();
		}
	}
	// 洗菜
	public void WashingVegetables() {
		System.out.println("洗菜");
	}
	// 加盐
	public void addSalt(){
		System.out.println("加盐");
	}
	// 加辣椒
	public void addChili() {
		System.out.println("加辣椒");
	}
	// 是否加辣椒钩子
	public boolean isChiliHooks() {
		return true;
	}
	// 放菜进锅炒，根据不同的实现，炒不同的菜
	abstract void addVegetables();
}
