package study.state;
// 已投币
public class HasMoneyState implements State{
	AutoSales as;
	
	public HasMoneyState() {
		super();
	}
	public HasMoneyState(AutoSales as) {
		this.as = as;
	}
	@Override
	public void insertMoney() {
		System.out.println("又投币了");
	}

	@Override
	public void exitMoney() {
		System.out.println("开始退币了");
		this.as.setState(this.as.getNoMoneyState());
	}

	@Override
	public void selectProduct() {
		System.out.println("选择产品");
	}

	@Override
	public void dispense() {
		System.out.println("发放产品");
		this.as.setState(this.as.getSoldState());
	}
	
}
