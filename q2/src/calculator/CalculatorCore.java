package calculator;

/**
 * @author Terry Fung
 * @since 25-10-2019
 */

import stack.*;
import queue.*;
import linkedList.EmptyListException;

/**
 *CalculatorCore is a core of calculator.
 *It provide function of infix to post-fix ,
 *and accepted to calculate equation string which included digital number and operator.
 */
public class CalculatorCore {
	
	private final String REGEX = "(?<=[-+*/])|(?=[-+*/])";
	private Queue postEquQueue;
	private String equation;
	private double result;
	/**
	 *Constructs a new CalculatorCore initialized.
	 * @throws EmptyListException 
	*/
	public CalculatorCore() {
		postEquQueue = new Queue();
		equation = null;
		result = 0;
	}
	
	/**
	 * This function will process the calculation .
	 * The program with make the input equation which is infix format to be a post-fix equation.
	 * Then,program will calculate the post-fix equation and return the result.
	 * @param equ The equation.
	 * @return The result as a double
	 * @exception EmptyListException On the list is empty.
	 * @exception EmptyEquationException On the String of equation is empty.

	 * */
	public double process()throws EmptyListException,EmptyEquationException {
		if(equation == null) throw new EmptyEquationException();
		
		Stack stack = new Stack();
		String[] postfix = infixToPostfix(equation).split(" ");
		System.out.println("Postfix Result : " + java.util.Arrays.toString(postfix));
		
		for (int i = 0; i < postfix.length; i++) {
			if(!isOperator(postfix[i])) {
				stack.push(Double.parseDouble(postfix[i]));
			}else {
				
				double v2 = (double)stack.pop();
				double v1 = (double)stack.pop();
				
				stack.push((double)calculate(postfix[i], v1, v2));
			}
		}
		return (double)stack.peek();

	}
	
	
	private String infixToPostfix(String equation) throws EmptyListException {
		Stack stack = new Stack();
		String[] equations = equation.split(REGEX);
		
		for (int i = 0; i < equations.length; i++) {
			if(isOperator(equations[i])) {
					if(stack.isEmpty() || checkPrecedence(equations[i])  > checkPrecedence((String)stack.peek()) ) {
						stack.push((String) equations[i]);
					}else {
						while (!stack.isEmpty() && checkPrecedence(equations[i])  < checkPrecedence((String)stack.peek())) {							
								postEquQueue.enqueue((String)stack.pop());
						}
						stack.push((String) equations[i]);
					}
			}else {
				postEquQueue.enqueue((String)equations[i]);
			}
		}
		while(!stack.isEmpty()) {
			postEquQueue.enqueue((String)stack.pop());
		}
		
		return toPostfixString(postEquQueue.toString()) ;
	}
	
	
	public void setEquation(String equation) throws EmptyListException {
		this.equation = equation;
		while (!postEquQueue.isEmpty()) {
			postEquQueue.dequeue();
		}
		
	}
	
	public String getEquation() {
		return equation;
	}
	
	public double getResult() {
		return result;
	}
	
	
	
	private double calculate(String operator , double v1 , double v2) {
			double result = 0;
			switch (operator) {
				case "+": result = v1 + v2;
				break;
				case "-": result = v1 - v2;
				break;
				case "*": result = v1 * v2;
				break;
				case "/": result = v1 / v2;
				break;
			}

			return result;
	}
	
	private String toPostfixString(String exp) {
		String r = exp.replace('[', ' ').replace(']', ' ').trim();
		return r;
		
	}
	
	private boolean isOperator(String c) {
		return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
	}
	
	private int checkPrecedence(String c1) {
			switch (c1) {
				case "+":
				case "-":
					return 1;	
				case "*":
				case "/":
					return 2;
			}
			return -1;
		
	}
	
	
	
	
		
	
}
