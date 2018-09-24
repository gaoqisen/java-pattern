package study.factoryAbstract;

public class run {
	public static void main(String args[]){
		MoonCakeStore1 mcs1 = new SouthMoonCakeStroe1();
		
		MoonCake1 mc12 = mcs1.orderMoonCake("meat");
		System.out.println(mc12.getName());
	}
}
