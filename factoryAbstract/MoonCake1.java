package study.factoryAbstract;

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

