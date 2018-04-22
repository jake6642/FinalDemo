package strategy;

import java.util.LinkedList;

import main.Adapter;

public class QuickSort {

	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;
	static int[] array;
	Adapter adapter = new Adapter();

	// constructor for arrays
	public QuickSort(int[] array) {
		sort(array, 0, array.length - 1);
		setArray(array);
	}

	// constructor for matrices
	public QuickSort(int[][] matrix) {
		// convert to array
		array = adapter.toArray(matrix);
		// sort it
		sort(array, 0, array.length - 1);
		// convert back to matrix
		setMatrix(adapter.toMatrix(array));
	}

	// constructor for linked lists
	public QuickSort(LinkedList<Integer> list) {
		// convert to array
		array = adapter.toArray(list);
		// sort it
		sort(array, 0, array.length - 1);
		// convert back to list
		setList(adapter.toList(array));
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

	/* Setter methods */
	public void setList(LinkedList<Integer> list) {
		QuickSort.lis = list;
	}

	public void setArray(int[] array) {
		QuickSort.arr = array;
	}

	public void setMatrix(int[][] matrix) {
		QuickSort.mat = matrix;
	}
}
