package study.decorate;

public class run {
	public static void main(String args[]) {
		House house  = new ChineseStyle();
		System.out.println(house.getDescription() + "***" +house.cost());
		// 英式风格的房子用 一张中式风格的桌子，和两把椅子，一把中式风格的，一把英式风格的椅子
		House house1 = new EnglandStyle();  // 英式风格的房子
		house1 = new ChineseDesk(house1);  
		house1 = new ChineseChair(house1);  
		house1 = new EnglandChair(house1);  
		System.out.println(house1.getDescription() + "***" +house1.cost());
		// 中式风格的房子用 一张中式风格的桌子，和两把椅子，一把中式风格的，一把英式风格的椅子
		House house2 = new ChineseStyle();  // 中式风格的房子
		house2 = new ChineseDesk(house2);  
		house2 = new ChineseChair(house2);  
		house2 = new EnglandChair(house2);  
		System.out.println(house2.getDescription() + "***" +house2.cost());
		// 后面就可以按照自己的喜欢装修自己的房子了
		// 其它的家具也可以更加灵活的添加了
	}
}
