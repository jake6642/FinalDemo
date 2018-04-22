package factory;

import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JPanel;

import main.Const;

/* 
 * Author: Jacob Collins
 * Date: 04-10-2018
 * 
 * Purpose: This will serve as a factory for data structures.
 * The user can select a data structure type from the MainFrame
 * and this will manufacture the data structure for display. 
 * 
 * */

@SuppressWarnings("serial")
public class StructureFactory extends JPanel {

	public GridLayout grid;
	static ArrayBuilder array;
	static ListBuilder list;
	static MatrixBuilder matrix;
	static int length;

	/*
	 * main constructor takes in the length of the data structure and the type of
	 * structure to create. It then instantiates a new builder
	 */
	public StructureFactory(String type, int length) {
		StructureFactory.length = length;
		grid = new GridLayout(1, 1, 5, 5);
		setLayout(grid);
		switch (type) {
		case (Const.ARRAY):
			array = new ArrayBuilder(length, this, grid);
			break;
		case (Const.MATRIX):
			matrix = new MatrixBuilder(length, this, grid);
			break;
		case (Const.LIST):
			list = new ListBuilder(length, this, grid);
			break;
		default:
			break;
		}
	}

	/* getters that will return the generated structure */
	public static int[] getArray() {
		return array.get();
	}

	public static int[][] getMatrix() {
		return matrix.get();
	}

	public static LinkedList<Integer> getList() {
		return list.get();
	}

	/*
	 * setters allow the structures to be updated externally if need be
	 */
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
