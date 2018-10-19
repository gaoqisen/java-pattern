package study.state;
// 状态接口
public interface State {
	public void insertMoney();   //  投币
	public void exitMoney();   // 退币
	public void selectProduct();  // 选择产品
	public void dispense(); //  发放产品
}
