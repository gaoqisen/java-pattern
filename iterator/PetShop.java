package study.iterator;
// 宠物店
public class PetShop {
	DoctorZhang zhang;
	DoctorLi li;
	public PetShop(DoctorZhang zhang,DoctorLi li) {
		this.zhang = zhang;
		this.li = li;
	}
	// 小花就用这个方法统计宠物
	public void printAnimal() {
		Iterator it = zhang.createIterator();
		Iterator its = li.createIterator();
		
		System.out.println("张医生的宠物");
		printAnimal(it);
		System.out.println("李医生的宠物");
		printAnimal(its);
	}
	private void printAnimal(Iterator it) {
		while(it.hasNext()) {
			Animal an = (Animal)it.next();
			System.out.println("名字为："+an.getName()+"   年龄为："+an.getAge() + "  介绍："+an.getDescription());
		}
	}
}
