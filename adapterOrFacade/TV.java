package study.adapterOrFacade;

public class TV {
	public void on() {
		System.out.println("开电视");
	}
	public void off() {
		System.out.println("关电视");
	}
}

class Light{
	public void on() {
		System.out.println("开电灯");
	}
	public void off() {
		System.out.println("关电灯");
	}
}
class Stove{
	public void on() {
		System.out.println("开火炉");
	}
	public void off() {
		System.out.println("关火炉");
	}
}