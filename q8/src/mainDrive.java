import java.util.Random;

public class mainDrive {
	public static void main(String[] args) {
			
		int[] a = new int[1000];
	
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		
		double startTime = System.nanoTime();
		int index = binarySearch(a, 0, a.length - 1, 1);
		double endTime  = System.nanoTime();
		System.out.println("index:" + index + " , Time: " + (endTime - startTime) + " ms");
	}
	
	public static int binarySearch(int[] array, int prev , int rear,int key) {
		if(prev > rear)
			return -(prev+1);
		
		int half = prev + (rear - prev) / 2;
		if(key < array[half]) {
			return binarySearch(array, prev, half -1, key);
		}else if(key > array[half]) {
			return binarySearch(array, half+1, rear, key);
		}else 
			return half;
		
	}
	
}
