import java.util.Arrays;

public class MainDrive {
	int test = 0;

	public static void main(String[] args) {
		int[] array = { 98, 38, 93, 33, 21, 6, 63, 81, 32 };
		MainDrive app = new MainDrive();
		double start = System.nanoTime();
		app.heapSort(array);
		double end = System.nanoTime();

		System.out.println("Sorted : " + Arrays.toString(array));
		System.out.println("Time: " + (end - start) + " ms.");
	}

	public void heapSort(int[] array) {
		int arrayLen = array.length;
		// start from index (n - 1) / 2
		for (int i = (arrayLen - 1) / 2; i >= 0; i--) {
			heapify(array, arrayLen, i);
		}
		System.out.println("heapified" + Arrays.toString(array));

		for (int i = arrayLen - 1; i >= 0; i--) {
			// root and last node
			swap(array, i, 0);
			heapify(array, i, 0);
		}

	}

	private void heapify(int[] array, int index, int i) {

		int root = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < index && array[left] > array[root])
			root = left;
		if (right < index && array[right] > array[root])
			root = right;
		if (root != i) {
			swap(array, root, i);
			heapify(array, index, root);
		}
	}

	private void swap(int[] arr, int v1, int v2) {
		int temp = arr[v2];
		arr[v2] = arr[v1];
		arr[v1] = temp;
	}

}
