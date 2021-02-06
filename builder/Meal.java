package study.builder;

import java.util.ArrayList;
import java.util.List;

// 餐
public class Meal {
	private List<Item> items = new ArrayList<Item>();
	public void add(Item it ){
		this.items.add(it);
	}
	public float getCost() {
		float cost = 0.0f;
		for(Item it : items) {
			cost += it.price();
		}
		return cost;
	}
	public void showItem(){
		for(Item it : items) {
			System.out.print("项目："+it.name());
			System.out.print(", " +it.packing().pack());
			System.out.println(", 价格" + it.price());
		}
	}
}
