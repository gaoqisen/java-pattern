package study.interpreter;

public class run {
	public static void main(String[] args) {
		Expression isMale = Interpreter.getMaleExpression();
		Expression isWoman = Interpreter.getWomanExpression();
		System.out.println("小李是女的"+ isWoman.interpret("小李"));
		System.out.println("小王是男的"+ isMale.interpret("小王"));
		System.out.println("小王是男的"+ isMale.interpret("小李"));
	}
}
