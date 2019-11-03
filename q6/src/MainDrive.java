import listStack.*;
import linkedList.EmptyListException;
public class MainDrive {
	public static void main(String[] args) {
		try {
				ListStack stack = new ListStack();
				stack.push(10);
				stack.push(15);
				stack.push("Apple");
				stack.push("Orange");
				stack.push(100);
				
				System.out.println(stack.toString());
				
				stack.pop();
				stack.pop();
				System.out.println(stack.toString());
				stack.pop();
				stack.pop();
				stack.pop();
				stack.pop();
				System.out.println(stack.toString());
			
			
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		
		}
		
}
