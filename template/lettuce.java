package study.template;
// 炒生菜
public class lettuce extends Cooking{

	@Override
	void addVegetables() {
		System.out.println("放入生菜");
	}
	// 不放辣椒
	public boolean isChiliHooks() {
		return false;
	}
}
