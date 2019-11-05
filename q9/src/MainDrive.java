import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        try{
        		System.out.println("Please input n.");
            int n = input.nextInt();
            	if(n < 0) {
            		System.out.println("no negative number");
            	}else {
            		System.out.println(Fibonacci(n));
			}
        }catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static int Fibonacci(int n) {
		if(n == 0) 
			return 0;
		else if(n==1) 
            return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
