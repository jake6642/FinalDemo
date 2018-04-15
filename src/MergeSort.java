import java.util.LinkedList;

public class MergeSort {
	
	static LinkedList<Integer> lis;
	static int[] arr;
	static int[][] mat;
	
	// constructor for arrays
	public MergeSort(int[] array){
		MergeSort.arr = array;
		sort(arr, 0, arr.length-1);
	}
	
	//constructor for matrices
	public MergeSort(int[][] matrix) {
		MergeSort.mat = matrix;
		int len = mat.length*mat.length;
		int[] array = new int[len];
		
		int k = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				array[k] = mat[i][j];
				k++;
			}
		}
		sort(array, 0, len-1);
		k = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = array[k];
				k++;
			}
		}
	}
	
	//constructor for linked lists
	public MergeSort(LinkedList<Integer> list) {
		MergeSort.lis = list;
	}
	
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
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
