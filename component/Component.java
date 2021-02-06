package study.component;

import java.util.List;

// 抽象组合类
public abstract class Component {
	String name;
	public Component(String name) {
		this.name = name;
	}
	public abstract void operation(int index); // 操作
}
