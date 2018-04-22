package factory;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* List class will build a linked lists for display 
 * if the factory instantiates it */
class ListBuilder {
	// create
	LinkedList<Integer> list;
	JTextField[] listBox;

	public ListBuilder(int length, JPanel panel, GridLayout grid) {
		// instantiate
		list = new LinkedList<Integer>();
		listBox = new JTextField[length];
		// update the grid
		grid.setColumns(length);
		grid.setRows(1);
		grid.setHgap(0);
		grid.setVgap(0);
		panel.add(new JLabel("null =>"));
		for (int i = 0; i < length; i++) {
			list.add(1);
			panel.add(listBox[i] = new JTextField(String.valueOf(list.get(i)), 3));
			listBox[i].setEditable(false);
			panel.add(new JLabel("=>"));
		}
		panel.add(new JLabel("null"));

		// initialize the list
		/* This will insert random variables into the list */
		randomFill(length);
	}

	// get/set/update
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

	// fill the list with random numbers
	public void randomFill(int length) {
		Random rand = new Random();
		LinkedList<Integer> lis = new LinkedList<Integer>();
		for (int i = 0; i <= length; i++) {
			int value = rand.nextInt(100);
			lis.add(value);
		}
		set(lis);
		update(length);
	}
}