package study.complex;

public class run {
	public static void main(String[] args) {
		DuckSimulator ds1 = new DuckSimulator();
		ds1.simulate();
		
		DuckSimulator ds = new DuckSimulator();
		AbstractDuckFactory adf = new CountingDuckFactory();
		ds.simulate(adf);
	}
}
