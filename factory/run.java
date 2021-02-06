package study.factory;

import study.factoryAbstract.MoonCake1;
import study.factoryAbstract.MoonCakeStore1;
import study.factoryAbstract.SouthMoonCakeStroe1;

public class run {
	public static void main(String args[]) {
		// easyfactory 生产月饼
		SimpleFactory simpleFactory = new SimpleFactory();
		new MoonCakeFactory(simpleFactory).orderMoonCake("meat");
		
		// factorymethod 生产月饼
		MoonCakeStore mcs = new SouthMoonCakeStroe();
		MoonCakeStore smcs = new NorthMoonCakeStore();
		
		MoonCake mc = mcs.orderMoonCake("meat");
		System.out.println(mc.getName());
		
		MoonCake mc1 = smcs.orderMoonCake("meat");
		System.out.println(mc1.getName());
		
	}
}
