package study.decorate;
// 英式风格
public class EnglandStyle extends House{
	public EnglandStyle() {
		description = "英式风格的房子";
	}
	@Override
	public double cost() {
		return 666;
	}
}
class EnglandChair extends Material{
	House house;
	public EnglandChair(House house){
		this.house = house;
	}
	public String getDescription() {
		return house.getDescription() + "＊＊＊英式风格的椅子";
	}
	public double cost () {
		return 20 + house.cost();
	}
}
class EnglandDesk extends Material{
	House house;
	public EnglandDesk(House house){
		this.house = house;
	}
	public String getDescription() {
		return house.getDescription() + "***英式风格的桌子";
	}
	public double cost () {
		return 50 + house.cost();
	}
}