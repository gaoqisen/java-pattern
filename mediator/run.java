package study.mediator;

public class run {
	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();
		
		AbstractMediator am = new Mediator(collA, collB);
		collA.setNumber(1000, am);
		System.out.println("collA:"+collA.getNumber());
		System.out.println("collB:"+collB.getNumber());
		
		System.out.println("-------");
		collB.setNumber(1000, am);
		System.out.println("collA:"+collA.getNumber());
		System.out.println("collB:"+collB.getNumber());
	}
}
