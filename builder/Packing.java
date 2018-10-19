package study.builder;
// 装食物的填料接口
public interface Packing {
	public String pack();  // 大包
}

// 包装纸材料
class Wrapper implements Packing{
	@Override
	public String pack() {
		return "包装材料";
	}
}
// 瓶子包装
class Bottle implements Packing{
	@Override
	public String pack() {
		return "瓶子包装";
	}
	
}