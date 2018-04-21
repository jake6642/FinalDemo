package strategy;
import java.util.LinkedList;

public class QuickSort {

	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;

	// constructor for arrays
	public QuickSort(int[] array) {
		QuickSort.arr = array;
		
		sort(arr, 0, arr.length - 1);
	}

	// constructor for matrices
	public QuickSort(int[][] matrix) {
		QuickSort.mat = matrix;
		int len = matrix.length * matrix.length;
		int[] array = new int[len];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				array[k] = matrix[i][j];
				k++;
			}
		}
		//sort it
		sort(array, 0, len-1);
		//convert back to matrix
		k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = array[k];
				k++;
			}
		}
		mat = matrix;
	}

	// constructor for linked lists
	public QuickSort(LinkedList<Integer> list) {
		QuickSort.lis = list;
		sort(lis, 0, lis.size()-1);
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
	
	int partition(LinkedList<Integer> list, int low, int high) {
		int pivot = list.get(high);
		int i = low-1; // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (list.get(j) <= pivot) {
				i++;

				//swap i and j
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = list.get(i+1);
		list.set(i+1, list.get(high));
		list.set(high, temp);

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	void sort(LinkedList<Integer> list, int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, list[pi] is now at right place
			 */
			int pi = partition(list, low, high);
			
			// Recursively sort elements before
			// partition and after partition
			sort(list, low, pi - 1);
			sort(list, pi + 1, high);
		}
	}

	/* getter methods */
	public static LinkedList<Integer> getList() {
		return lis;
	}

	public static int[] getArray() {
		return arr;
	}

	public static int[][] getMatrix() {
		return mat;
	}
}
