import calculator.*;
import linkedList.EmptyListException;

public class MainDrive {
	public static void main(String[] args) {
		try {
				new CalculatorUI().init();
				
			}catch (EmptyListException e) {
				System.out.print(e.getMessage());
			
			}catch (Exception e) {
				System.out.print("Unexcepted Error : " + e.getMessage());
			}
	}
}
