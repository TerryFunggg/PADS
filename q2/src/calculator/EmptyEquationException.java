package calculator;
public class EmptyEquationException extends Exception {
	public EmptyEquationException() {
		super("Can not see any equation there.Please input an equation");
	}
}
