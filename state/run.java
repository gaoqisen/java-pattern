package study.state;

public class run {
	public static void main(String args[]) {
		// 给自动售货机装5个产品
		AutoSales as = new AutoSales(5);  
		System.out.println("--当前状态：" +as.getState().getClass());
		
		as.insertMoney();
		System.out.println("--当前状态：" +as.getState().getClass());
		as.selectProduct();
		as.dispense();
		
		System.out.println("--当前状态：" +as.getState().getClass());
		as.exitMoney();
		System.out.println("--当前状态：" +as.getState().getClass());
		as.insertMoney();
		as.selectProduct();
		as.insertMoney();
		as.selectProduct();
		as.dispense();
		System.out.println("--当前状态：" +as.getState().getClass());
	}
}
