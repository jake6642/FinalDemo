package factory;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class Matrix {
	int[][] matrix;
	JTextField[][] matrixBox;

	public Matrix(int length, JPanel panel, GridLayout grid) {
		matrix = new int[length][length];
		matrixBox = new JTextField[length][length];
		grid.setColumns(length);
		grid.setRows(length);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				panel.add(matrixBox[i][j] = new JTextField(String.valueOf(matrix[i][j]), 3));
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
	}
}
