package study.iterator;

import java.util.ArrayList;

public interface Iterator {
	boolean hasNext();
	Object next();
}
// 张医生迭代器实现迭代器接口
class DoctorZhangIterator implements Iterator{
	ArrayList ans;
	int index = 0;
	public DoctorZhangIterator(ArrayList ans) {
		this.ans = ans;
	}
	@Override
	public boolean hasNext() {
		if (index >= ans.size() || ans.get(index) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Animal animal = (Animal) ans.get(index);
		index ++;
		return animal;
	}
	
}
//李医生迭代器实现迭代器接口
class DoctorLiIterator implements Iterator{
	Animal[] animal;
	int index = 0;
	public DoctorLiIterator(Animal[] animal) {
		this.animal = animal;
	}
	@Override
	public boolean hasNext() {
		if (index >= animal.length || animal[index] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Animal an = animal[index];
		index ++;
		return an;
	}
	
}