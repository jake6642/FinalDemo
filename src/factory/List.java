package factory;

import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class List {
	LinkedList<Integer> list;
	JTextField[] listBox;

	public List(int length, JPanel panel, GridLayout grid) {
		list = new LinkedList<Integer>();
		listBox = new JTextField[length];

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