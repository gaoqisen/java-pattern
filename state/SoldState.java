package study.state;
// 售出状态
public class SoldState implements State{
	AutoSales as;
	
	public SoldState(AutoSales as) {
		this.as = as;
	}

	@Override
	public void insertMoney() {
		System.out.println("又投币了");
	}

	@Override
	public void exitMoney() {
		System.out.println("产品已售出,无法退币");
	}

	@Override
	public void selectProduct() {
		System.out.println("选择产品");
	}

	@Override
	public void dispense() {
		System.out.println("出货");
		if (this.as.getCount() >0 ) {
			this.as.setState(as.getNoMoneyState());  // 将状态变为没投币之前
		} else {
			System.out.println("产品卖完了");
			this.as.setState(as.getSoldOutState());  // 将状态变为售罄
		}
	}

}
