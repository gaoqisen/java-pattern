package study.state;
// 自动售货机
public class AutoSales {
	State soldOutState;
	State noMoneyState;
	State hasMoneyState;
	State soldState;

	State state = soldState;
	int  count = 0;
	
	public AutoSales(int num) {
		this.count = num;
		soldOutState = new SoldOutState(this);
		noMoneyState = new NoMoneyState(this);
		hasMoneyState = new HasMoneyState(this);
		soldState = new SoldState(this);
		if (num>0) {
			state = noMoneyState;
		}
	}
	//  投币
	public void insertMoney(){
		state.insertMoney();
	};  
	// 退币
	public void exitMoney(){
		this.state.exitMoney();
	};  
	// 选择产品
	public void selectProduct(){
		this.state.selectProduct();
	};  
	//  发放产品
	public void dispense(){
		this.state.dispense();
	}; 
	public void setState(State state) {
		this.state = state;
	}
	public State getSoldOutState() {
		return soldOutState;
	}
	public State getNoMoneyState() {
		return noMoneyState;
	}
	public State getHasMoneyState() {
		return hasMoneyState;
	}
	public State getSoldState() {
		return soldState;
	}
	public State getState() {
		return state;
	}
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "AutoSales [售罄=" + soldOutState.getClass() + ", 待投币=" + noMoneyState.getClass() + ", 已投币="
				+ hasMoneyState.getClass() + ", 出售=" + soldState.getClass() + ", state状态=" + state.getClass() + ", count=" + count + "]";
	}
}
