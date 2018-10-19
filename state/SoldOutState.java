package study.state;
// 售謦状态
public class SoldOutState implements State{
	AutoSales autoSales;
	
	public SoldOutState() {
		super();
	}
	public SoldOutState(AutoSales as) {
		this.autoSales = as;
	}
	@Override
	public void insertMoney() {
		System.out.println("以售罄，请不要投币");
		this.autoSales.setState(this.autoSales.getSoldOutState());  // 将状态改为售罄
	}

	@Override
	public void exitMoney() {
		System.out.println("以售罄，无法退币");
	}

	@Override
	public void selectProduct() {
		System.out.println("以售罄，无法选择产品");
	}

	@Override
	public void dispense() {
		System.out.println("以售罄，无法获得产品");
	}

}
