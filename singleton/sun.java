package study.singleton;
// 单例模式  太阳（synchronized，重量级）
public class sun {
	private static sun s = null;
	
	private sun() {}
	// 单例模式  这种方式多线程时会出现混乱的情况，不建议使用
	public static sun getSun() {
		if (s == null) {
			s = new sun();
		}
		return s;
	}
	// (同步方法)添加同步锁，在不考虑性能的时候可以使用该方法
	public static synchronized sun getSunSyn() {
		if (s == null) {
			s = new sun();
		}
		return s;
	}
}
// 月亮（双重检查加锁）
class moon {
	// volatile 当moon初始化为实例时，能保证多个线程正确的处理moon变量
	private volatile static moon m;
	
	private moon() {};
	//  减少synchronized的使用
	public static moon getMoon() {
		if (m == null) {
			synchronized (moon.class) {
				if (m == null) {
					m = new moon();
				}
			}
		}
		return m;
	}
}
// 地球（急切）
class earth{
	// 在静态初始化器中创建单件，这段代码保证了线程安全
	private static earth e = new earth();
	
	private earth(){};
	// 在jvm 加载这个类的时候创建此唯一的单例模式。
	public static earth getEarth() {
		return e;
	}
}