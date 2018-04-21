package factory;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

/* Array class will build an array for display 
 * if the factory instantiates it */
class ArrayBuilder {
	//create
	int[] array;
	JTextField[] arrayBox;

	public ArrayBuilder(int length, JPanel panel, GridLayout grid) {
		//instantiate
		array = new int[length];
		arrayBox = new JTextField[length];
		//update the grid
		grid.setColumns(length);
		grid.setRows(1);
		for (int i = 0; i < length; i++) {
			panel.add(arrayBox[i] = new JTextField(String.valueOf(array[i]), 3));
			arrayBox[i].setEditable(false);
		}
		
		//fill with random numbers
		randomFill(length);
	}

	// getters/setters/updaters
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
	
	//enters random numbers into the array
	public void randomFill(int length) {
		Random rand = new Random();
		int[] arr = new int[length];
		int value = 0;
		for (int i = 0; i < length; i++) {
			value = rand.nextInt(100);
			arr[i] = value;
		}
		set(arr);
		update(length);
	}

}