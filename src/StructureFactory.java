import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StructureFactory extends JPanel {

	private static final long serialVersionUID = 1L;
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
			array = new Array(length);
			break;
		case (Const.MATRIX):
			matrix = new Matrix(length);
			break;
		case (Const.LIST):
			list = new List(length);
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

	public class Array {
		int[] array;
		JTextField[] arrayBox;

		public Array(int length) {
			array = new int[length];
			arrayBox = new JTextField[length];
			grid.setColumns(length);
			grid.setRows(1);
			for (int i = 0; i < length; i++) {
				add(arrayBox[i] = new JTextField(String.valueOf(array[i]), 3));
				arrayBox[i].setEditable(false);
			}
		}

		public int[] get() {
			return array;
		}

		public void set(int[] arr) {
			array = arr;
		}

		public void update(int length) {
			for (int i = 0; i < length; i++) {
				arrayBox[i].setText(String.valueOf(array[i]));
			}
		}

	}

	private class Matrix {
		int[][] matrix;
		JTextField[][] matrixBox;

		public Matrix(int length) {
			matrix = new int[length][length];
			matrixBox = new JTextField[length][length];
			grid.setColumns(length);
			grid.setRows(length);
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					add(matrixBox[i][j] = new JTextField(String.valueOf(matrix[i][j]), 3));
					matrixBox[i][j].setEditable(false);
				}
			}
		}

		public int[][] get() {
			return matrix;
		}

		public void set(int[][] mat) {
			matrix = mat;
		}

		public void update(int length) {
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					matrixBox[i][j].setText(String.valueOf(matrix[i][j]));
				}
			}
			System.out.println("test");
		}
	}

	private class List {
		LinkedList<Integer> list;
		JTextField[] listBox;

		public List(int length) {
			list = new LinkedList<Integer>();
			listBox = new JTextField[length];

			grid.setColumns(length);
			grid.setRows(1);
			grid.setHgap(0);
			grid.setVgap(0);
			add(new JLabel("null =>"));
			for (int i = 0; i < length; i++) {
				list.add(1);
				add(listBox[i] = new JTextField(String.valueOf(list.get(i)), 3));
				listBox[i].setEditable(false);
				add(new JLabel("=>"));
			}
			add(new JLabel("null"));
		}

		public LinkedList<Integer> get() {
			return list;
		}

		public void set(LinkedList<Integer> lis) {
			list = lis;
		}

		public void update(int length) {
			for (int i = 0; i < length; i++) {
				listBox[i].setText(String.valueOf(list.get(i)));
			}
		}
	}

}
