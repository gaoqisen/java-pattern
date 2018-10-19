package study.adapterOrFacade;
// 买了一个大插板，将电视、烤火炉、电灯的插头都插在这个大插板上面
public class FacadeSocket {
	TV tv;
	Light light;
	Stove stove;
	public FacadeSocket(TV tv,Light light,Stove stove) {
		this.tv = tv;
		this.light = light;
		this.stove = stove;
	}
	// 通过外观模式统一处理
	public void on() {
		this.tv.on();
		this.light.on();
		this.stove.on();
	}
	public void off() {
		this.tv.off();
		this.light.off();
		this.stove.off();
	}
}
