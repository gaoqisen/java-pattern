package study.decorate;
// 房子抽象类
public abstract class House {
	String description = "毛坯房";  // 房子的描述
	public String getDescription() {
		return this.description;
	}
	public abstract double cost();   // 房子的成本成本
}
