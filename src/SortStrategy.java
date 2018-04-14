import java.util.ArrayList;
import java.util.LinkedList;

public class SortStrategy {
	public SortStrategy(String type, int length) {
		switch (type) {
		case (Const.HEAP):
			//new HeapSort();
			break;
		case (Const.QUICK):
			//new QuickSort();
			break;
		case (Const.MERGE):
			//new MergeSort();
			break;
		default:
			break;
		}
	}
	
	private class HeapSort{
		//constructor for arrays and matrices
		public HeapSort(ArrayList array) {
			
		}
		
		//constructor for linked lists
		public HeapSort(LinkedList list) {
			
		}
	}
	
	private class QuickSort{
		
	}
	
	private class MergeSort{
		
	}
	
	private class DijkstraAlgo{
		
	}
	
	private class BellmanAlgo{
		
	}
	
	private class FloydAlgo{
		
	}
}
