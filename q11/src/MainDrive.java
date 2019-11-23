import java.util.Arrays;

public class MainDrive {

	public static void main(String[] args) {
		int[] array = { 98, 38, 93, 33, 21, 6, 63, 81, 32 };
		MainDrive app = new MainDrive();
		app.bubble(array);
		System.out.println(Arrays.toString(array));
	}

	public void bubble(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}

	}

	private void swap(int[] arr, int v1, int v2) {
		int temp = arr[v2];
		arr[v2] = arr[v1];
		arr[v1] = temp;
	}

}
