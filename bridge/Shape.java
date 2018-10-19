package study.bridge;
// 形状抽象类
public abstract class Shape {
	ColorAPI colorAPI;
	ShapeAPI shapeAPI;
	Shape(ColorAPI ca ,ShapeAPI sa) {
		this.colorAPI = ca;
		this.shapeAPI = sa;
	}
	// 画的抽象方法
	public abstract void draw();
}
// 形状实现
class ShapeImpl extends Shape{
	
	ShapeImpl(ColorAPI ca, ShapeAPI sa) {
		super(ca, sa);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw() {
		this.colorAPI.Draw();
		this.shapeAPI.Draw();
	}
}