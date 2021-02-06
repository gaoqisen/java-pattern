package study.decorate;
// 中式风格的房子
public class ChineseStyle extends House{
	public ChineseStyle() {
		description = "中式风格的房子";
	}
	@Override
	public double cost() {
		return 888;
	}

}
// 中式风格的椅子
class ChineseChair extends Material{
	House house;
	public ChineseChair(House house){
		this.house = house;
	}
	public String getDescription() {
		return house.getDescription() + "＊＊＊中式风格的椅子";
	}
	public double cost () {
		return 20 + house.cost();
	}
}
// 中式风格的桌子
class ChineseDesk extends Material{
	House house;
	public ChineseDesk(House house){
		this.house = house;
	}
	public String getDescription() {
		return house.getDescription() + "***中式风格的桌子";
	}
	public double cost () {
		return 50 + house.cost();
	}
}