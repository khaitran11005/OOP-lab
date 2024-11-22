package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixAddition{
	
	static int[][] MatrixAdder(int[][] mat1, int[][] mat2) {
		int row = mat1.length;
		int col = mat1[0].length;
		if (row != mat2.length || col != mat2[0].length) {
			throw new NumberFormatException("Matrices must be of the same size to perform addition.");
		}
		
		int[][] result = new int[row][col];
		for (int i = 0; i < result.length; i++) {
			for (int k = 0; k < result[i].length; k++) {
				result[i][k] = mat1[i][k] + mat2[i][k];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Insert number of columns: ");
		int columns = scanner.nextInt();
		int[][] mat1 = new int[rows][columns];
		int[][] mat2 = new int[rows][columns];
		
		System.out.println("Insert values for the first matrix: ");
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				System.out.println("Value for matrix 1, row " + (i+1) + ", column " + (k+1) + ":");
				mat1[i][k] = scanner.nextInt();
			}
		}
		
		System.out.println("Insert values for the second matrix: ");
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				System.out.println("Value for matrix 2, row " + (i+1) + ", column " + (k+1) + ":");
				mat2[i][k] = scanner.nextInt();
			}
		}
		int[][] output = MatrixAdder(mat1, mat2);
		System.out.println("Addition result");
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				System.out.print(output[i][k] + " ");
			}
			System.out.println("");
		}
		scanner.close();
	}
}