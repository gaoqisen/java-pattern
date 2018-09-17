package study.observer;

import java.util.ArrayList;
// 新闻公众号
public class NewsOfficialAccounts implements OfficialAccounts{
	private ArrayList users;
	private String content;
	
	public NewsOfficialAccounts () {
		users = new ArrayList();
	}
	@Override
	public void follow(User user) {  // 关注该公众号
		users.add(user);
	}

	@Override
	public void unfollow(User user) {  // 取消关注
		int i = users.indexOf(user);
		if(i>=0) {
			users.remove(i);
		}
	}
	@Override
	public void sendMessageAll() {  //  给所有用户发送文章
		for(int i = 0; i<users.size();i++) {
			User user = (User) users.get(i);
			user.acceptMessage(content);
		}
	}
	public void setContent(String content){// 设置消息自动给所有用户发送文章
		this.content = content;
		sendMessageAll();
	}
}
