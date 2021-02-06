package study.observer;

public class UserTom implements User{
	private String name = "tom";
	private String message;
	private OfficialAccounts os;
	@Override
	public void acceptMessage(String content) {
		System.out.println(name+"接收到了"+content);
		this.message = content;
	}
	public UserTom(OfficialAccounts os) {  // 构造器作为关注公众号用
		this.os = os;
		os.follow(this);
	}
}
