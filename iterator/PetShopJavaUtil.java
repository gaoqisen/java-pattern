package study.iterator;
// 宠物店
import java.util.Iterator;
public class PetShopJavaUtil {
	Doctor zhang;
	Doctor li;
	public PetShopJavaUtil(Doctor zhang,Doctor li) {
		this.zhang = zhang;
		this.li = li;
	}
	public void printAnimal() {
		Iterator it = zhang.createIterator();
		Iterator its = li.createIterator();
		
		System.out.println("张医生的宠物");
		printAnimal(it);
		System.out.println("李医生的宠物");
		printAnimal(its);
	}
	private void printAnimal(Iterator it) {
		if (it == null) {
			return;
		}
		while(it.hasNext()) {
			Animal an = (Animal)it.next();
			System.out.println("名字为："+an.getName()+"   年龄为："+an.getAge() + "  介绍："+an.getDescription());
		}
	}
}
