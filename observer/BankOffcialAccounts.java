package study.observer;

import java.util.Observable;

public class BankOffcialAccounts extends Observable{ // 实现java自带的可观察者接口
	private String content;  // 接受的消息
	public BankOffcialAccounts(){};  // 构造器
	public void changed() {    // 消息变化方法
		setChanged();
		notifyObservers();   // 通知所有观察者
	}
	public void sendMessage(String content) {  // 发送消息
		this.content = content;
		changed();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {   // 写入公众号内容
		this.content = content;
	}
	
}
