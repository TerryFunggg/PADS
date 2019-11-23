package calculator;

/**
 * @author Terry_Fung
 * @since 25-10-2019
 */

import stack.*;

import linkedList.EmptyListException;
import linkedList.LinkedList;

/**
 *CalculatorCore is a core of calculator.
 *It provide function of infix to post-fix ,
 *and accepted to calculate equation string which included digital number and operator.
 */
public class CalculatorCore {
	
	private final String REGEX = "(?<=[-+*/])|(?=[-+*/])";
	private LinkedList postfixList;
	private String equation;
	private double result;
	/**
	 *Constructs a new CalculatorCore initialized.
	 * @throws EmptyListException 
	*/
	public CalculatorCore() {
		postfixList = new LinkedList();
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
		for ( String token : equations) {
			if(!isOperator(token)){
				postfixList.addToTail(token);
			}else {
				while (!stack.isEmpty() 
						&& checkPrecedence((String)stack.peek()) > checkPrecedence(token)) {
					postfixList.addToTail((String)stack.pop());						
				}
				stack.push((String)token);
			}
		}
		
		while(!stack.isEmpty()) {
			postfixList.addToTail((String)stack.pop());
		}
		return toPostfixString(postfixList.toString()) ;
	}
	
	
	public void setEquation(String equation) throws EmptyListException {
		this.equation = equation;
		while (!postfixList.isEmpty()) {
			postfixList.removeFromTail();
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
					return 3;
			}
			return -1;
		
	}
	
	
	
	
		
	
}
