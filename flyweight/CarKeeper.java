package study.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CarKeeper {
	private Map<String, Car> map = new HashMap<String, Car>();
	
	public Car getCar(String name) {
		Car car = this.map.get(name);
		if (car == null) {
			car = new Car(name);
			this.map.put(name, car);
			return car;
		}
		return car;
	}
}
