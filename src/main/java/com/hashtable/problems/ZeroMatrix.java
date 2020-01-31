package com.hashtable.problems;

//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to 0.
public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 0 } };
		zeroMatrix(matrix);
	}

	private static void zeroMatrix(int[][] matrix) {
		boolean[] zeroRow = new boolean[matrix.length];
		boolean[] zeroColumn = new boolean[matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 0) {
					zeroRow[row] = true;
					zeroColumn[column] = true;
				}
			}
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (zeroRow[row] || zeroColumn[column]) {
					matrix[row][column] = 0;
				}
			}
		}
		
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}

	}

}
