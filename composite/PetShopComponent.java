package study.composite;
// 宠物组件
public abstract class PetShopComponent {
	// 增加宠物组件
	public void add(PetShopComponent pc) {
		throw new UnsupportedOperationException();
	}
	// 删除宠物组件
	public void remove(PetShopComponent pc) {
		throw new UnsupportedOperationException();
	}
	// 获取宠物组件
	public PetShopComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	public String getName(){  //获取名字
		throw new UnsupportedOperationException();
	}
	public String getDes() { // 获取详情
		throw new UnsupportedOperationException();
	}
	public int getAge() { // 获取年龄
		throw new UnsupportedOperationException();
	}
	public void print() { // 输出
		throw new UnsupportedOperationException();
	}
}
