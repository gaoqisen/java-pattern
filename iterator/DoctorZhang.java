package study.iterator;

import java.util.ArrayList;

// 张医生用ArrayList笼子关动物
public class DoctorZhang {
	ArrayList ans;
	public DoctorZhang() {
		ans = new ArrayList();
		addAnimal("小狗",8, "黄色的小狗");
		addAnimal("小猫",4, "黑色的小猫");
		addAnimal("小猪",4, "白色的小猪");
	}
	// 增加动物方法
	public void addAnimal(String name, int age, String des){
		Animal an = new Animal(name, age, des);
		this.ans.add(an);
	}
	public Iterator createIterator() {
		return new DoctorZhangIterator(this.ans);
	}
}
// 李医生用［］笼子关动物
class DoctorLi{
	static final int MAX=5;
	int number = 0;
	Animal[] animal;
	public DoctorLi() {
		animal =new Animal[MAX];
		addAnimal("小乌龟",8, "黄色的小乌龟");
		addAnimal("小猴",4, "黑色的小猴");
		addAnimal("大猪",4, "黄色的大猪");
	}
	// 增加动物方法
	public void addAnimal(String name, int age, String des){
		if (number>=MAX){
			return;
		}
		Animal an = new Animal(name, age, des);
		this.animal[number] = an;
		this.number++;
	}
	public Iterator createIterator() {
		return new DoctorLiIterator(this.animal);
	}
}
