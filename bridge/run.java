package study.bridge;

public class run {
	public static void main(String[] args) {
		Shape redCircle = new ShapeImpl(new Red(), new Circle());
		Shape greenSquare = new ShapeImpl(new Green(), new Square());
		redCircle.draw();
		greenSquare.draw();
	}
}
