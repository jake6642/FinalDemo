package strategy;
import java.util.LinkedList;

import factory.StructureFactory;
import main.Const;

public class SortStrategy {
	public SortStrategy(String type, String sortType) {

		switch (sortType) {
		case (Const.HEAP):
			switch (type) {
			case Const.ARRAY:
				new HeapSort(StructureFactory.getArray());
				break;
			case Const.MATRIX:
				new HeapSort(StructureFactory.getMatrix());
				break;
			case Const.LIST:
				new HeapSort(StructureFactory.getList());
				break;
			default:
				break;
			}
			break;
		case (Const.QUICK):
			switch (type) {
			case Const.ARRAY:
				new QuickSort(StructureFactory.getArray());
				break;
			case Const.MATRIX:
				new QuickSort(StructureFactory.getMatrix());
				break;
			case Const.LIST:
				new QuickSort(StructureFactory.getList());
				break;
			default:
				break;
			}
			break;
		case (Const.MERGE):
			switch (type) {
			case Const.ARRAY:
				new MergeSort(StructureFactory.getArray());
				break;
			case Const.MATRIX:
				new MergeSort(StructureFactory.getMatrix());
				break;
			case Const.LIST:
				new MergeSort(StructureFactory.getList());
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	public static int[] getSortedArray(String type) {
		switch (type) {
		case Const.HEAP:
			return HeapSort.getArray();
		case Const.MERGE:
			return MergeSort.getArray();
		case Const.QUICK:
			return QuickSort.getArray();
		default:
			return null;
		}
	}

	public static int[][] getSortedMatrix(String type) {
		switch (type) {
		case Const.HEAP:
			return HeapSort.getMatrix();
		case Const.MERGE:
			return MergeSort.getMatrix();
		case Const.QUICK:
			return QuickSort.getMatrix();
		default:
			return null;
		}
	}

	public static LinkedList<Integer> getSortedList(String type) {
		switch (type) {
		case Const.HEAP:
			return HeapSort.getList();
		case Const.MERGE:
			return MergeSort.getList();
		case Const.QUICK:
			return QuickSort.getList();
		default:
			return null;
		}
	}

}
