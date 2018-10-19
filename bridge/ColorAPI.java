package study.bridge;
// 颜色api
public interface ColorAPI {
	// 画
	public void Draw();
}
// 红色
class Red implements ColorAPI{
	@Override
	public void Draw() {
		System.out.println("用红色的笔" );
	}
}
// 绿色
class Green implements ColorAPI{
	@Override
	public void Draw() {
		System.out.println("用绿色的笔");
	}
	
}
// 形状api
interface ShapeAPI {
	// 画
	public void Draw();
}
// 圆形
class Circle implements ShapeAPI{
	@Override
	public void Draw() {
		System.out.println("画圆形");
	}
	
}
class Square implements ShapeAPI{
	@Override
	public void Draw() {
		System.out.println("画正方形");
	}
	
}