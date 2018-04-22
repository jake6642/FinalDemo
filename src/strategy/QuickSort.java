package strategy;

import java.util.LinkedList;

import main.Adapter;

public class QuickSort {

	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;
	static int[] array;
	Adapter adapter = new Adapter();
	static int parts = 0;
	static int sorts = 0;
	static int swaps = 0;

	// constructor for arrays
	public QuickSort(int[] array) {
		parts = 0;
		sorts = 0;
		swaps = 0;
		sort(array, 0, array.length - 1);
		printResults();
		setArray(array);
	}

	// constructor for matrices
	public QuickSort(int[][] matrix) {
		parts = 0;
		sorts = 0;
		swaps = 0;
		// convert to array
		array = adapter.toArray(matrix);
		// sort it
		sort(array, 0, array.length - 1);
		printResults();
		// convert back to matrix
		setMatrix(adapter.toMatrix(array));
	}

	// constructor for linked lists
	public QuickSort(LinkedList<Integer> list) {
		parts = 0;
		sorts = 0;
		swaps = 0;
		// convert to array
		array = adapter.toArray(list);
		// sort it
		sort(array, 0, array.length - 1);
		printResults();
		// convert back to list
		setList(adapter.toList(array));
	}

	private void printResults() {
		System.out.print("-------------\nResults:\n");
		System.out.print("    " + swaps + " Swaps\n");
		System.out.print("    " + sorts + " Sorts\n");
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int low, int high) {
		parts++;
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				swap(arr, i, j);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		swap(arr, i + 1, high);
		return i + 1;
	}

	private void swap(int[] arr, int i, int j) {
		swaps++;
		System.out.print("    Swapping index " + i + " and " + j + "\n");
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		for (int m = 0; m < arr.length; m++) {
			if (m == i || m == j)
				System.out.print("[" + arr[m] + "] ");
			else
				System.out.print(arr[m] + " ");
		}
		System.out.println("");
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void sort(int arr[], int low, int high) {
		sorts++;
		System.out.print("    Sorting " + low + " and " + high + "\n");
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pivot = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
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
