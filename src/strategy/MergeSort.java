package strategy;

import java.util.LinkedList;

import main.Adapter;

public class MergeSort {

	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;
	Adapter adapter = new Adapter();
	static int merges = 0;
	static int sorts = 0;

	// constructor for arrays
	public MergeSort(int[] array) {
		setArray(array);
		merges = 0;
		sorts = 0;
		sort(arr, 0, arr.length - 1);
		printResults(array);
	}

	// constructor for matrices
	public MergeSort(int[][] matrix) {
		setMatrix(matrix);
		merges = 0;
		sorts = 0;
		//convert to array
		int[] array = adapter.toArray(matrix);
		//sort the array
		sort(array, 0, array.length- 1);
		printResults(array);
		//convert back to matrix
		setMatrix(adapter.toMatrix(array));
	}

	// constructor for linked lists
	public MergeSort(LinkedList<Integer> list) {
		setList(list);
		merges = 0;
		sorts = 0;
		// convert to array
		int[] array = adapter.toArray(list);
		// sort the array
		sort(array, 0, array.length - 1);
		printResults(array);
		// turn it back into a list
		setList(adapter.toList(array));
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) {
		System.out.print("\nSorting... "+l+" and "+r+"\n");
		sorts++;
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;
			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r) {
		merges++;
		// Find sizes of two subarrays to be merged
		int tempSize1 = m - l + 1;
		int tempSize2 = r - m;

		/* Create temp arrays */
		int L[] = new int[tempSize1];
		int R[] = new int[tempSize2];
		
		System.out.print("\nMerging");
		/* Copy data to temp arrays */
		System.out.print("\n    L: ");
		for (int i = 0; i < tempSize1; ++i) {
			L[i] = arr[l + i];
			System.out.print(L[i] + " ");
		}
		System.out.print("\n    and");
		System.out.print("\n    R: ");
		for (int j = 0; j < tempSize2; ++j) {
			R[j] = arr[m + 1 + j];
			System.out.print(R[j] + " ");
		}

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays and merged
		int i = 0, j = 0, k = l;

		while (i < tempSize1 && j < tempSize2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < tempSize1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < tempSize2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public void printResults(int[] array) {
		System.out.print("\n");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
		System.out.println("-------------\nResults:");
		System.out.print("    "+sorts+" Sorts\n    "+merges+" Merges\n");
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
	
	/*Setter methods*/
	public void setList(LinkedList<Integer> list) {
		MergeSort.lis = list;
	}
	public void setArray(int[] array) {
		MergeSort.arr = array;
	}
	public void setMatrix(int[][] matrix) {
		MergeSort.mat = matrix;
	}
}
