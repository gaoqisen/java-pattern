package study.mediator;
// 抽象中介者
public abstract class AbstractMediator {
	public AbstractColleague A;
	public AbstractColleague B;
	public AbstractMediator(AbstractColleague A, AbstractColleague B){
		this.A = A;
		this.B =B;
	}
	public abstract void AaffectB();  // a转b
	public abstract void BaffectA();  // b转a
}
// 中介者
class Mediator extends AbstractMediator{

	public Mediator(AbstractColleague A, AbstractColleague B) {
		super(A, B);
	}

	@Override
	public void AaffectB() {
		int i = A.getNumber();
		B.setNumber(i*1000);
	}

	@Override
	public void BaffectA() {
		int i = B.getNumber();
		A.setNumber(i/1000);
	}
	
}
