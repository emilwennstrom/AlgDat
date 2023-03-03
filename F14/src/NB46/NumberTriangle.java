package NB46;

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Random;

import static java.lang.Math.max;


public class NumberTriangle {

  /*
        1  0  0  0  0
        1  1  0  0  0
        1  1  1  0  0
        1  1  1  1  0
        1  1  1  1  1

                0,0
            1,0     1,1
        2,0     2,1     2,2

        left = row++
        right = row++ && col++




    */

	private int[][] triangle;
	private int[][] savedValues;
	private int[][] savedBottomUp;
	private final int depth;

	private int slow = 0;
	private int dyn = 0;

	public NumberTriangle(int depth) {
		this.depth = depth;
		initTriangle(depth);
	}

	private void initTriangle(int depth){
		triangle = new int[depth][depth];
		savedValues = new int[depth][depth];
		Random random = new Random();
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				triangle[i][j] = Integer.MIN_VALUE;
				savedValues[i][j] = Integer.MIN_VALUE;
			}
		}
		int numOnRow = depth - 1;
		for (int i = depth - 1; i >= 0; i--) {
			for (int j = numOnRow; j >= 0; j--) {
				triangle[numOnRow][j] = random.nextInt(0, 9);
			}
			numOnRow--;
		}
	}

	private void printTriangle() {
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle.length; j++) {
				if (triangle[i][j] == Integer.MIN_VALUE) {
					System.out.print("X  ");
				} else {
					System.out.print(triangle[i][j]+ " ");
					if (triangle[i][j] < 10) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	public int getMaxSum() {
		if (depth == 0) return 0;
		if (depth == 1) return triangle[depth][depth];
		int startRow = 0, startCol = 0;
		return getMaxSum(startRow, startCol);
	}

	private int getMaxSum(int row, int col){
		slow++;
		if (depth - 1 == row || col == depth - 1) return triangle[row][col];
		return triangle[row][col] + max(getMaxSum(row + 1, col), getMaxSum(row + 1, col + 1));
	}

	public int getDynamicMaxSum() {
		if (depth == 0) return 0;
		if (depth == 1) return triangle[depth][depth];
		int startRow = 0, startCol = 0;
		return getDynamicMaxSum(startRow, startCol);
	}

	private int getDynamicMaxSum(int row, int col){
		dyn++;
		if (depth - 1 == row || col == depth - 1) return triangle[row][col];
		int max;
		if (savedValues[row][col] != Integer.MIN_VALUE) {
			max = savedValues[row][col];
		} else {
			max = triangle[row][col] + max(getDynamicMaxSum(row + 1, col), getDynamicMaxSum(row + 1, col + 1));
			savedValues[row][col] = max;
		}
		return max;
	}


	private int getBottomUp() {
		int currentLength = depth;
		for (int row = depth - 1; row >= 1; row--) {
			for (int col = 0; col < currentLength - 1; col++) {
				int left = triangle[row][col] + triangle[row-1][col];
				int right = triangle[row][col + 1] + triangle[row-1][col];
				triangle[row-1][col] = max(left, right);
			}
			currentLength--;
		}
		return triangle[0][0];
	}


	public static void main(String[] args) {
		NumberTriangle t = new NumberTriangle(5);
		t.printTriangle();
		System.out.println("Max summa: " + t.getMaxSum() + ", anrop utan dynamisk: " + t.slow);
		System.out.println("Max summa: " + t.getDynamicMaxSum() + ", anrop med dynamisk topdown: " + t.dyn);
		System.out.println("Max summa: " + t.getBottomUp() + " (bottom up)");
		t.printTriangle();
	}
}
