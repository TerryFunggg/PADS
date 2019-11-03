
public class MainDrive {
	double sum = 0;
	
	public static void main(String[] args) {
		MainDrive app = new MainDrive();
		app.harmonic(83);
		System.out.println(app.sum);
	}
	
	
	void harmonic(int n) {
		if(n == 0) return;
		this.sum += (1.0/n);

		harmonic(n - 1);
	}
}
