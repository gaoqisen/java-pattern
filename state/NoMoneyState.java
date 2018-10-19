package study.state;
// 没有投币的状态
public class NoMoneyState implements State{
	AutoSales as;
	
	public NoMoneyState() {
		super();
	}
	public NoMoneyState(AutoSales as) {
		this.as = as;
	}
	@Override
	public void insertMoney() {
		System.out.println("投币了");
		this.as.setState(this.as.getHasMoneyState());  // 将状态改为以投币
	}

	@Override
	public void exitMoney() {
		System.out.println("没有投币，无法退币");
	}

	@Override
	public void selectProduct() {
		System.out.println("没有投币，无法选择产品");
	}

	@Override
	public void dispense() {
		System.out.println("没有投币，无法出货");
	}
	
}
