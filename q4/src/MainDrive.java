
/**
 * @author Terry Fung
 * @since 23-10-2019
 */

import circularList.*;

public class MainDrive {
	public static void main(String[] args) {
		try {
			CircularList circularList = new CircularList();
			// Testing push
			circularList.push(12);
			circularList.push(10);
			circularList.push("ddd");
			circularList.push("TY");
			System.out.println(circularList.toString());
			
//			// Testing delete
			circularList.removeFromTail();
			System.out.println(circularList);
			circularList.removeFromHead();
			System.out.println(circularList);
			circularList.removeFromTail();
			System.out.println(circularList);
			circularList.removeFromHead();
			System.out.println(circularList);
			
			circularList.removeFromTail();
				
		} catch (EmptyListException e) {
		
			System.out.print(e.getMessage());
		}
	}
}
