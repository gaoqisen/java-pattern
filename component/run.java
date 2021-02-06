package study.component;

public class run {
	public static void main(String[] args) {
		Composite root = new Composite("root");
		
		Composite branch = new Composite("branch");
		Composite branch1 = new Composite("branch1");
		Composite branch2 = new Composite("branch2");
		Composite branch3 = new Composite("branch3");
		
		branch.add(new Leaf("leaf1"));
		branch.add(new Leaf("leaf2"));
		branch1.add(new Leaf("leaf3"));
		branch2.add(new Leaf("leaf4"));
		branch1.add(branch2);
		
		branch2.add(new Leaf("leaf5"));
		branch2.add(new Leaf("leaf6"));
		branch3.add(new Leaf("leaf7"));
		branch3.add(new Leaf("leaf8"));
		branch2.add(branch3);
		
		root.add(branch);
		root.add(branch1);
		root.operation(0);
	}
}
