package FloydWarshall;

import java.util.Random;

import static java.lang.Math.min;

public class ShortestPathPair {


	static void floydWarshall(double[][] m, int n) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					m[i][j] = min(m[i][j], m[i][k] + m[k][j]);
				}
			}
		}
	}


	public static void main(String[] args) {
		int size = 7;
		double[][] matrix = createNodes(size);
		printMatrix(matrix);
		floydWarshall(matrix, size);
		System.out.println();
		printMatrix(matrix);
	}

	static void printMatrix(double[][] matrix) {
		int size = matrix.length;
		System.out.print("    ");
		for (int i = 0; i < size; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		for (int i = 0; i < size; i++) {
			sb.append("---");
		}
		System.out.println(sb);
		for (int i = 0; i < size; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == Double.POSITIVE_INFINITY) {
					System.out.print("X  ");
				} else {
					System.out.print((int)matrix[i][j] + " ");
					if (matrix[i][j] < 10) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static double[][] createNodes(int size) {
		double[][] m = new double[size][size];
		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j) {
					int r = rand.nextInt(1, size);
					if (r == 1) {
						m[i][j] = Double.POSITIVE_INFINITY;
					} else {
						m[i][j] = Math.floor(rand.nextDouble(1, 20));
					}
				}
			}
		}


		return m;
	}





}
