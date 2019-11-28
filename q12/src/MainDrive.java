import java.util.Arrays;
import java.util.*;

/**
 * @author : Terry Fung
 * @since : 15-11-2019
 **/
public class MainDrive {

	public static void main(String[] args) {
		int[] n = new int[] { 99, 22, 3, 11 };
		MainDrive app = new MainDrive();
		app.init();
//		System.out.println("Before sorted: " + Arrays.toString(n));
//		app.quickSort(n);
//		System.out.println("After sorted: " + Arrays.toString(n));
	}

	public void init() {
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please input number of items");
			int n = input.nextInt();
			System.out.println("Please input values , using ',' to split");
			String[] v = input.next().split(",");
			int[] values = new int[n];
			String result = "Your input values : { ";
			for (int i = 0; i < n; i++) {

				values[i] = Integer.parseInt(v[i]);
				result += values[i] + " ";
			}
			System.out.println(result + " }");

			quickSort(values);

			System.out.println("After sorted: " + Arrays.toString(values));

			String a = "";
			do {
				System.out.println("Again? type a or type q to quite");
				a = input.next();
				if (a.equals("q"))
					return; 

			} while (!a.equals("a"));

		}

	}

	public void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private void sort(int[] a, int low, int high) {
		if (high <= low) {
			return;
		}
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	private int partition(int[] array, int low, int high) {
		int i = low;
		int j = high + 1;
		int v = array[low];

		while (true) {

			while (array[++i] < v)
				if (i == high)
					break;
			while (v < array[--j])
				if (j == low)
					break;

			if (i >= j)
				break;

			swap(array, i, j);
		}

		swap(array, low, j); // put v = array[j] into position

		return j;

	}

	private void swap(int[] a, int i, int j) {
		int item = a[i];
		a[i] = a[j];
		a[j] = item;
	}

}
