package study.mediator;
// 抽象同事类
public abstract class AbstractColleague {
	public int number;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int num) {
		this.number = num;
	}
	public abstract void setNumber(int number, AbstractMediator am);
}
// 同事a
class ColleagueA extends AbstractColleague{

	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.AaffectB();
	}
}
// 同事b
class ColleagueB extends AbstractColleague{

	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.BaffectA();
	}
}