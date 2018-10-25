package study.interpreter;
// 和表达式
public class AndExpression implements Expression{
	private Expression ex1;
	private Expression ex2;
	public AndExpression(Expression ex1, Expression ex2) {
		this.ex1 = ex1;
		this.ex2 = ex2;
	}
	@Override
	public boolean interpret(String content) {
		return ex1.interpret(content) && ex2.interpret(content);
	}
}
