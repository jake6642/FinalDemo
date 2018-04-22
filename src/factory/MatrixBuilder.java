package factory;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

/* Matrix class will build a matrix for display 
 * if the factory instantiates it */
class MatrixBuilder {
	// create
	int[][] matrix;
	JTextField[][] matrixBox;

	public MatrixBuilder(int length, JPanel panel, GridLayout grid) {
		// instantiate
		matrix = new int[length][length];
		matrixBox = new JTextField[length][length];

		// update the grid
		grid.setColumns(length);
		grid.setRows(length);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				panel.add(matrixBox[i][j] = new JTextField(String.valueOf(matrix[i][j]), 3));
				matrixBox[i][j].setEditable(false);
			}
		}

		// fill the matrix
		randomFill(length);
	}

	// get/set/update
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
	}

	// enters random numbers into the matrix
	public void randomFill(int length) {
		Random rand = new Random();
		int[][] mat = new int[length][length];
		int value;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				value = rand.nextInt(100);
				mat[i][j] = value;
			}
		}
		set(mat);
		update(length);
	}
}
