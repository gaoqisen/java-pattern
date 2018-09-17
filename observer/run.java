package study.observer;

public class run {
	public static void main(String args[]) {
		// 创建一个新闻的公众号
		NewsOfficialAccounts noa = new NewsOfficialAccounts();
		// 创建用户
		UserTom tom = new UserTom(noa);
		UserJason jason = new UserJason(noa);
		BankOffcialAccounts bank = new BankOffcialAccounts();
		UserJDK jdk = new UserJDK(bank);
		// 发送消息
		noa.setContent("新闻消息1");
		noa.setContent("新闻消息2");
		jason.unfollow();   // 取消关注，jason无法接收消息3
		noa.setContent("新闻消息3");
		bank.sendMessage("发送消息4");
	}
}
