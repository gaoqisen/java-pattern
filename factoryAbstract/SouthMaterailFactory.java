package study.factoryAbstract;

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
