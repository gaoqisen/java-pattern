package study.interpreter;
// 解析器
public class Interpreter {
	// 获取男性表达式
	public static Expression getMaleExpression(){
		Expression wang = new TerminalExpression("小王");
		Expression zhang = new TerminalExpression("小张");
		return new OrExpression(wang,zhang);
	}
	// 获取女性表达式
	public static Expression getWomanExpression() {
		Expression wu = new TerminalExpression("小吴");
		Expression li = new TerminalExpression("小李");
		return new OrExpression(wu,li);
	}
}
