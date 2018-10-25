package study.interpreter;
// 与表达式
public class OrExpression implements Expression{
	private Expression ex1;
	private Expression ex2;
	public OrExpression (Expression ex1, Expression ex2) {
		this.ex1 = ex1;
		this.ex2 = ex2;
	}
	@Override
	public boolean interpret(String content) {
		return this.ex1.interpret(content) || this.ex2.interpret(content);
	}
}
