之前学的是装饰者模式
## 装饰者模式的优点
动态地为对象增加新的功能或者撤销功能（继承就不能做到这一点）
## 装饰者模式的缺点
会产生过多的相似的对象！
## 一、对工厂模式的理解
简单工厂：通过工厂类生成不同的类。工厂类返回一个父类型的类，通过if或者switch判断用户给的数据，通过不同的数据返回不同的类。
工厂方法：比较重要的就是抽象类里面的一个抽象方法，所有继承了抽象类的类都必须实现该方法，之后在调用的时候利用多态动态的调用实现类的方法。抽象的方法里面就可以用简单工厂模式实现不同的类
## 二、代码实现(简单工厂、工厂方法、抽象工厂)
1、简单工厂

创建月饼类
```
public class MoonCake {
	public String name;
	public void kenad() {
		System.out.println("揉面粉");
	}
	public String getName() {
		return name;
	}
}
// 糖陷月饼
class sugar extends MoonCake{
	public sugar(){
		System.out.println("糖陷");
	}
}
// 肉陷月饼
class meat extends MoonCake {
	public meat() {
		System.out.println("肉馅");
	}
}
```
创建简单月饼工厂
```
public class SimpleFactory {
	public MoonCake createProduct(String type) {
		MoonCake product = null;
		if (type.equals("meat")){
			product = new meat();
		} else if (type.equals("sugar")) {
			product = new sugar();
		}
		return product;
	}
}
```
创建月饼工厂
```
public class MoonCakeFactory {
	SimpleFactory factory;
	public MoonCakeFactory(SimpleFactory factory) {
		this.factory = factory;
	}
	public MoonCake orderMoonCake(String type) {
		MoonCake product = factory.createProduct(type);
		return product;
	}
}
```
main方法实现
```
public class run {
	public static void main(String args[]) {
		// easyfactory 生产月饼
		SimpleFactory simpleFactory = new SimpleFactory();
		new MoonCakeFactory(simpleFactory).orderMoonCake("meat");
	}
}
```
运行结果
```
肉馅
```
2、工厂方法
月饼店抽象类
```
// 月饼店
public abstract class MoonCakeStore {
	public MoonCake orderMoonCake(String type) {
		MoonCake mc;
		mc = createMoonCake(type);
		mc.kenad();
		return mc;
	}
	// 抽象的工厂方法
	public abstract MoonCake createMoonCake(String type);
}
```
北方月饼店和南方月饼店
```
// 北方月饼店
public class NorthMoonCakeStore extends MoonCakeStore{

	@Override
	public MoonCake createMoonCake(String type) {
		if (type.equals("meat")) {
			return new NorthSytleMeatMoonCake();
		} else if (type.equals("sugar")) {
			return new NorthSytleSugarMoonCake();
		}
		return null;
	}
}

// 南方月饼店
public class SouthMoonCakeStroe extends MoonCakeStore{

	@Override
	public MoonCake createMoonCake(String type) {
		if (type.equals("meat")) {
			return new SouthSytleMeatMoonCake();
		} else if (type.equals("sugar")) {
			return new SouthSytleSugarMoonCake();
		}
		return null;
	}
}
```
月饼父类
```
public class MoonCake {
	public String name;
	public void kenad() {
		System.out.println("揉面粉");
	}
	public String getName() {
		return name;
	}
}
```
北方月饼和南方月饼
```
class SouthSytleMeatMoonCake extends MoonCake{
	public SouthSytleMeatMoonCake() {
		name ="南方风格的肉馅月饼";
	}
}
class SouthSytleSugarMoonCake extends MoonCake{
	public SouthSytleSugarMoonCake() {
		name = "南方风格的糖陷月饼";
	}
}
```
main方法实现
```
public class run {
	public static void main(String args[]) {
		// factorymethod 生产月饼
		MoonCakeStore mcs = new SouthMoonCakeStroe();
		MoonCakeStore smcs = new NorthMoonCakeStore();
		
		MoonCake mc = mcs.orderMoonCake("meat");
		System.out.println(mc.getName());
		
		MoonCake mc1 = smcs.orderMoonCake("meat");
		System.out.println(mc1.getName());
	}
}
```
运行结果
```
揉面粉
南方风格的肉馅月饼
揉面粉
北方风格的肉馅月饼
```
3.抽象工厂

创建一个抽象月饼类

```
// 面粉基类
class flour {
	
}

// 芝麻基类
class sesame{
	
}
// 重构之前的抽象月饼类
public abstract class MoonCake1 {
	String name;
	flour flour;
	sesame sesame;
	public void kenad() {
		System.out.println("揉面粉");
	}
	public String getName() {
		return name;
	}
	// 准备
	abstract void prepare();
}
//糖陷月饼
class sugar1 extends MoonCake1{
	MaterailFactory materailFactory;
	public sugar1(){
		System.out.println("糖陷");
	}
	public sugar1(MaterailFactory materailFactory) {
		name = "糖陷月饼";
		this.materailFactory = materailFactory;
	}
	@Override
	void prepare() {
		System.out.println("准备制作月饼了");
		flour = this.materailFactory.createFlour();
		sesame = this.materailFactory.createSesame();
	}
}
//肉陷月饼
class meat1 extends MoonCake1 {
	MaterailFactory materailFactory;
	public meat1() {
		System.out.println("肉馅");
	}
	public meat1(MaterailFactory materail) {
		this.materailFactory = materail;
	}
	@Override
	void prepare() {
		flour = this.materailFactory.createFlour();
		sesame = this.materailFactory.createSesame();
	}
}
```
抽象月饼店
```
// 月饼店抽象类	
public abstract class MoonCakeStore1 {
	public MoonCake1 orderMoonCake(String type) {
		MoonCake1 mc;
		mc = createMoonCake(type);
		mc.kenad();
		mc.prepare();
		return mc;
	}
	// 抽象的工厂方法
	public abstract MoonCake1 createMoonCake(String type);
}
```
材料接口
```
// 材料工厂接口
public interface MaterailFactory {
	public flour createFlour();
	public sesame createSesame();
}

```
南方材料工厂实现材料接口
```
// 南方材料工厂
public class SouthMaterailFactory implements MaterailFactory{

	@Override
	public flour createFlour() {
		return new SouthFlour();
	}

	@Override
	public sesame createSesame() {
		return new SouthSesame();
	}
}
// 南方面粉
class SouthFlour extends flour{
	public SouthFlour() {
		System.out.println("南方的独特制作的面粉");
	}
}
// 南方芝麻
class SouthSesame extends sesame{
	public SouthSesame() {
		System.out.println("南方的独特制作的芝麻");
	}
}

```
南方月饼店继承抽象月饼店
```
// 南方月饼店
public class SouthMoonCakeStroe1 extends MoonCakeStore1{

	@Override
	public MoonCake1 createMoonCake(String type) {
		MaterailFactory mf = new SouthMaterailFactory();
		if (type.equals("meat")) {
			return new sugar1(mf);
		} else if (type.equals("sugar")) {
			return new meat1(mf);
		}
		return null;
	}
}
```
运行代码
```
public class run {
	public static void main(String args[]){
		MoonCakeStore1 mcs1 = new SouthMoonCakeStroe1();
		
		MoonCake1 mc12 = mcs1.orderMoonCake("meat");
		System.out.println(mc12.getName());
		MoonCake1 mc11 = mcs1.orderMoonCake("meat");
		System.out.println(mc11.getName());
	}
}
```
运行结果
```
揉面粉
准备制作月饼了
南方的独特制作的面粉
南方的独特制作的芝麻
糖陷月饼
```
## 三、UML类图
![easyfactory      ](https://upload-images.jianshu.io/upload_images/7172355-e25809d542ed6799.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![factorymethod](https://upload-images.jianshu.io/upload_images/7172355-5937266ecfea4c1b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![abstractfactory](https://upload-images.jianshu.io/upload_images/7172355-af03f70212447f70.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 四、笔记

面向对象原则

> 多用组合，少用继承

> 针对接口编程、不针对实现编程

> 为交互之间的松耦合设计而努力

> 类应该对扩展开发、修改关闭《开闭原则》

> 依赖抽象、不要依赖具体类《依赖倒置原则》

工厂方法模式定义

 > 定义了一个创建对象的接口，但由于之类子类要决定要实例化哪一个。工厂方法让类的实例推迟到子类

> 抽象工厂模式定义

>  提供了一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类

注：抽象工厂模式的代码比较复杂，只是做材料的UML类图