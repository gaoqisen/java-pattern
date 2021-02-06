package study.observer;

public class UserJason implements User{
	private String name = "jason";
	private String message;
	private OfficialAccounts os;
	@Override
	public void acceptMessage(String content) {
		System.out.println(name+"接收到了"+content);
		this.message = content;
	}
	public UserJason(OfficialAccounts os) {  // 构造器作为关注公众号用
		this.os = os;
		os.follow(this);
	}
	public void unfollow(){  // 取消关注
		os.unfollow(this);
	}
}
