import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StructureFactory extends JPanel {

	private static final long serialVersionUID = 1L;
	public GridLayout grid;

	public StructureFactory(String type, int length) {
		grid = new GridLayout(1, 1, 5, 5);
		setLayout(grid);
		switch (type) {
		case (Const.ARRAY):
			new Array(length);
			break;
		case (Const.MATRIX):
			new Matrix(length);
			break;
		case (Const.LIST):
			new List(length);
		default:
			break;
		}
	}

	public int random() {
		Random rand = new Random();
		int value = rand.nextInt(100);
		System.out.print(rand);
		return value;
	}

	private class Array {
		public Array(int length) {
			int[] array = new int[length];
			JTextField[] arrayBox = new JTextField[length];
			grid.setColumns(length);
			grid.setRows(1);
			for (int i = 0; i < length; i++) {
				int random = random();
				array[i] = random;
				add(arrayBox[i] = new JTextField(String.valueOf(array[i]), 3));
			}
		}
	}

	private class Matrix {
		public Matrix(int length) {
			int[][] matrix = new int[length][length];
			JTextField[][] matrixBox = new JTextField[length][length];
			grid.setColumns(length);
			grid.setRows(length);
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					int random = random();
					matrix[i][j] = random;
					add(matrixBox[i][j] = new JTextField(String.valueOf(matrix[i][j]), 3));
				}
			}
		}
	}

	private class List {
		public List(int length) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			JTextField[] listBox = new JTextField[length];

			grid.setColumns(length);
			grid.setRows(1);
			grid.setHgap(0);
			grid.setVgap(0);
			for (int i = 0; i < length; i++) {
				int random = random();
				list.add(random);
				add(listBox[i] = new JTextField(String.valueOf(list.get(i)), 3));
				add(new JLabel("=>"));
			}

		}
	}

}
