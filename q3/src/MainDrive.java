
/**
 * @author Terry Fung
 * @since 25-10-2019
 */

public class MainDrive {
	private double sum = 0;
	
	public static void main(String[] args) {
		MainDrive app = new MainDrive();
		
		app.recursiveHarmonic(10);
		System.out.println("RecursiveHarmonic = " + app.getSum());
		
		//app.harmonic(150);
	}
		
	void recursiveHarmonic(double n) {
		if(n <= 0) return;
		this.sum += (1.0/n);

		recursiveHarmonic(n - 1);
	}
	
	public double getSum() {
		return sum;
	}
	
	void harmonic(double d) {
		 sum = 0;
		for(int i=1;i<=d;i++)
		{
			sum=sum+(1d/i);
			
		}
		System.out.println("harmonic = "+sum);
	}
}
