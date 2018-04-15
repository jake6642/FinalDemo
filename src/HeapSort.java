import java.util.LinkedList;

class HeapSort {

	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;

	// constructor for linked lists
	public HeapSort(LinkedList<Integer> list) {
		HeapSort.lis = list;
		for (int i = 0; i < 5; i++) {
			System.out.print(lis.get(i) + " ");
		}
		startSort(5);
		for (int i = 0; i < 5; i++) {
			System.out.print(lis.get(i) + " ");
		}

	}

	// constructor for arrays
	public HeapSort(int[] array) {

		int n = array.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(array, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			// call max heapify on the reduced heap
			heapify(array, i, 0);
		}
		arr = array;
	}

	// constructor for matrices
	public HeapSort(int[][] matrix) {

		int[] array = new int[matrix.length * matrix.length];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				array[k] = matrix[i][j];
				k++;
			}
		}
		new HeapSort(array);
		k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = array[k];
				k++;
			}
		}
		mat = matrix;
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	public void startSort(int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(i, length);
		}
		for (int i = length - 1; i > 0; i--) {
			swap(0, i); // swap the first element(biggest) to the sorted group in each time
			heapify(0, i); // check maxHeap's properties with unsorted group
		}
	}

	public void heapify(int root, int length) {
		int left = root * 2 + 1; // left Child -> n*2+1
		int right = root * 2 + 2; // Right Child -> n*2+2
		int maxHeap = root; // assume root is largest

		/* check whether it fulfills the maxHeap's properties */
		maxHeap = left < length && lis.get(left) > lis.get(maxHeap) ? left : maxHeap;
		maxHeap = right < length && lis.get(right) > lis.get(maxHeap) ? right : maxHeap;

		if (maxHeap != root) { // It means not fulfill
			swap(root, maxHeap); // swap
			heapify(maxHeap, length); // check again
		}
	}

	public void swap(int i, int j) {
		int tmp = lis.get(i);
		lis.set(i, lis.get(j));
		lis.set(j, tmp);
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
