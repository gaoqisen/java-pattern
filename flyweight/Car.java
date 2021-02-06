package study.flyweight;

public class Car {
	private String brand;
	public Car(String brand){
		System.out.println("___创建"+brand+"汽车");
		this.brand = brand;
	}
	
	public void drive() {
		System.out.println("开"+ brand + "车");
	}
}
