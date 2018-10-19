package study.composite;

import java.util.ArrayList;

public class PedShop extends PetShopComponent{
	ArrayList com = new ArrayList();
	String name;
	String des;
	public PedShop(String name, String des) {
		this.name = name;
		this.des = des;
	}
}
