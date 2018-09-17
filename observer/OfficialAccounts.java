package study.observer;
/**
 * 公众号类
 * @author gaoqisen
 *
 */
public interface OfficialAccounts {
	public void follow(User user);   // 关注公众号
	public void unfollow(User user);	// 取消关注
	public void sendMessageAll();  // 给所有的用户发送消息
}
