package study.builder;

public class run {
	public static void main(String[] args) {
		MealBuilder mb = new MealBuilder();
		Meal vegMeal = mb.prepareVegMeal();
		vegMeal.showItem();
		System.out.println("蔬菜餐的总价："+ vegMeal.getCost());
		
		Meal nonvegMeal = mb.prepareNonVegMeal();
		nonvegMeal.showItem();
		System.out.println("肉类餐的总价："+ nonvegMeal.getCost());
	}
}
