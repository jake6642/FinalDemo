package factory;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Const;

@SuppressWarnings("serial")
public class StructureFactory extends JPanel {

	public GridLayout grid;
	static Array array;
	static List list;
	static Matrix matrix;
	static int length;

	public StructureFactory(String type, int length) {
		StructureFactory.length = length;
		grid = new GridLayout(1, 1, 5, 5);
		setLayout(grid);
		switch (type) {
		case (Const.ARRAY):
			array = new Array(length, this, grid);
			break;
		case (Const.MATRIX):
			matrix = new Matrix(length, this, grid);
			break;
		case (Const.LIST):
			list = new List(length, this, grid);
		default:
			break;
		}
		initStructures(type, length);
	}

	public void initStructures(String type, int len) {
		int[] arr = new int[len];
		int[][] mat = new int[len][len];
		LinkedList<Integer> lis = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			Random rand = new Random();
			arr[i] = rand.nextInt(100);
			lis.add(rand.nextInt(100));
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = rand.nextInt(100);
			}
		}
		switch (type) {
		case Const.ARRAY:
			array.set(arr);
			array.update(len);
			break;
		case Const.MATRIX:
			matrix.set(mat);
			matrix.update(len);
			break;
		case Const.LIST:
			list.set(lis);
			list.update(len);
		}

	}

	public static int[] getArray() {
		return array.get();
	}

	public static int[][] getMatrix() {
		return matrix.get();
	}

	public static LinkedList<Integer> getList() {
		return list.get();
	}

	public void setArray(int[] arr) {
		array.set(arr);
		array.update(length);
	}

	public void setMatrix(int[][] mat) {
		matrix.set(mat);
		matrix.update(length);
	}

	public void setList(LinkedList<Integer> lis) {
		list.set(lis);
		list.update(length);
	}

}
