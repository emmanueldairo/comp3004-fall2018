package core;

public class ArithmeticSolver {
	public double add(double left, double right) {
		return left+right;
	}
	public double subtract(double left, double right) {
		return left-right;
	}
	public double multiply(double left, double right) {
		return left*right;
	}
	public double divide(double left, double right) {
		return left/right;
	}
	public double modulus(double left, double right) {
		return left%right;
	}
	public double solve(String operator, double leftBox, double rightBox) {
		double answer=0;
		switch (operator) {
			case "+":
				answer=add(leftBox, rightBox);
				break;
			case "-":
				answer=subtract(leftBox, rightBox);
				break;
			case "x":
				answer=multiply(leftBox, rightBox);
				break;
			case "/":
				answer=divide(leftBox, rightBox);
				break;
			case "%":
				answer=modulus(leftBox, rightBox);
				break;
	
			default:
				break;
		}
		return answer;
	}
	
}
