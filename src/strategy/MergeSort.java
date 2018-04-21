package strategy;
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
		sort(list, 0, list.size()-1);
	}
	
    void sort(LinkedList<Integer> lis, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(lis, l, m);
            sort(lis , m+1, r);

            // Merge the sorted halves
            merge(lis, l, m, r);
        }
    }
    
    void merge(LinkedList<Integer> lis, int lft, int mid, int rt)
    {
        // Find sizes of two subarrays to be merged
        int tempSize1 = mid - lft + 1;
        int tempSize2 = rt - mid;

        /* Create temp arrays */
        int tempL[] = new int [tempSize1];
        int tempR[] = new int [tempSize2];

        /*Copy data to temp arrays*/
        for (int i=0; i<tempSize1; ++i)
            tempL[i] = lis.get(lft+i);
        for (int j=0; j<tempSize2; ++j)
        	tempR[j] = lis.get(mid+1+j);


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays and merged
        int i = 0, j = 0, k = lft;

        while (i < tempSize1 && j < tempSize2)
        {
            if (tempL[i] <= tempR[j])
            {
                lis.set(k, tempL[i]);
                i++;
            }
            else
            {
            	lis.set(k, tempR[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of tempL[] if any */
        while (i < tempSize1)
        {
            lis.set(k,  tempL[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of tempR[] if any */
        while (j < tempSize2)
        {
            lis.set(k,  tempR[j]);
            j++;
            k++;
        }
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int tempSize1 = m - l + 1;
        int tempSize2 = r - m;

        /* Create temp arrays */
        int L[] = new int [tempSize1];
        int R[] = new int [tempSize2];

        /*Copy data to temp arrays*/
        for (int i=0; i<tempSize1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<tempSize2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays and merged
        int i = 0, j = 0, k = l;

        while (i < tempSize1 && j < tempSize2)
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
        while (i < tempSize1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < tempSize2)
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
