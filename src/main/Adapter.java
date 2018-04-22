package main;

import java.util.LinkedList;

/*
 * Author: Jacob Collins
 * Date: 04-21-2018
 * 
 * Purpose:This class is intended to speed up the 
 * conversion of data structure types to and from 
 * the array type. This way sorting doesn't have
 * to be implemented for each type, but only for
 * the array type. 
 * 
 * */
public class Adapter {

	public Adapter() {
	}

	public int[] toArray(LinkedList<Integer> inList) {
		System.out.println("Converting List to Array");
		int[] array = new int[inList.size()];

		for (int i = 0; i < array.length; i++) {
			array[i] = inList.get(i);
		}
		return array;
	}

	public int[] toArray(int[][] matrix) {
		System.out.println("Converting Matrix to Array");
		int length = matrix.length * matrix.length;
		int[] array = new int[length];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

				array[k] = matrix[i][j];
				k++;
			}
		}
		return array;
	}

	public LinkedList<Integer> toList(int[] array) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	public int[][] toMatrix(int[] array) {
		int length = (int) Math.sqrt((double) array.length);
		int[][] matrix = new int[length][length];

		int k = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = array[k];
				k++;
			}
		}
		return matrix;
	}
}
