package factory;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class Array {
	int[] array;
	JTextField[] arrayBox;

	public Array(int length, JPanel panel, GridLayout grid) {
		array = new int[length];
		arrayBox = new JTextField[length];
		grid.setColumns(length);
		grid.setRows(1);
		for (int i = 0; i < length; i++) {
			panel.add(arrayBox[i] = new JTextField(String.valueOf(array[i]), 3));
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