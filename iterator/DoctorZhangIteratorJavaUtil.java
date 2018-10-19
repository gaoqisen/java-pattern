package study.iterator;

import java.util.ArrayList;
import java.util.Iterator;
// 张医生实现java util里面的迭代器
public class DoctorZhangIteratorJavaUtil implements Iterator{
	Animal[] ans;
	int index = 0;
	public DoctorZhangIteratorJavaUtil(Animal[] ans) {
		this.ans = ans;
	}
	@Override
	public boolean hasNext() {
		if (index >= ans.length || ans[index] == null) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public Object next() {
		Animal animal = (Animal) ans[index];
		index ++;
		return animal;
	}
	public void remove() {
		if (index <=0) {
			throw new IllegalStateException("没有可以删除的了");
		}
		if(ans[index-1] !=null) {
			for(int i = index-1; i<(ans.length -1); i++) {
				ans[i] = ans[i+1];
			}
			ans[ans.length - 1] = null;
		}
	}
}
class DoctorLiIteratorJavaUtil implements Iterator{
	ArrayList ans;
	int index = 0;
	public DoctorLiIteratorJavaUtil(ArrayList ans) {
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