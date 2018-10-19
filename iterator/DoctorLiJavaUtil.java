package study.iterator;

import java.util.ArrayList;
import java.util.Iterator;
// 张医生用ArrayList区分动物
public class DoctorLiJavaUtil implements Doctor{
	ArrayList ans;
	public DoctorLiJavaUtil() {
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
		// 直接使用ArrayList的迭代器
		return this.ans.iterator();
	}
}
// 李医生用［］区分动物
class DoctorZhangJavaUtil implements Doctor{
	static final int MAX=5;
	int number = 0;
	Animal[] animal;
	public DoctorZhangJavaUtil() {
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
		return new DoctorZhangIteratorJavaUtil(this.animal);
	}
}
// 新增的医生接口
interface Doctor {
	public Iterator createIterator();
}
