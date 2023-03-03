package uppgift4;

import java.util.Arrays;

public class Main {

    static int finRow;
    static int finCol;

    static int regCount;
    static int tabCount;

    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                        {4,	4,	-3,	5,	2,	2},
                        {1,	2,	-2,	3,	3,	1},
                        {5,	-4,	-3,	1,	4,	4},
                        {0,	2,	3,	2,	-5,	1}};

        finRow = m.length;
        finCol = m[0].length;
        int[][] tab = new int[finRow][finCol];
        for (int[] ints : tab) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        tabCount = 0;
        regCount = 0;

        System.out.println(highestSumTab(m, tab));
        System.out.println("Tab: " + tabCount);
        System.out.println(highestSum(m));
        System.out.println("Reg: " + regCount);
    }

    private static int highestSum(int[][] m) {
        int row = 0, col = 0;
        return highestSum(m, row, col);
    }

    private static int highestSum(int[][] m, int row, int col) {
        regCount++;
        if (row == finRow - 1 && col == finCol - 1) {
            return m[row][col];
        }
        int oneRight = Integer.MIN_VALUE, twoRight = Integer.MIN_VALUE, oneDown = Integer.MIN_VALUE;
        if (col + 1 < finCol) {
            oneRight = m[row][col] + highestSum(m, row, col + 1);
        }
        if (col + 2 < finCol) {
            twoRight = m[row][col] + highestSum(m, row, col + 2);
        }
        if (row + 1 < finRow) {
            oneDown = m[row][col] + highestSum(m, row + 1, col);
        }
        return Math.max(oneRight, Math.max(twoRight, oneDown));
    }

    private static int highestSumTab (int[][] m, int[][] tab){
        int row = 0, col = 0;
        return highestSumTab(m, row, col, tab);
    }
    private static int highestSumTab(int[][] m, int row, int col, int[][] tab) {
        tabCount++;
        if (tab[row][col] != Integer.MIN_VALUE) {
            return tab[row][col];
        }
        if (row == finRow - 1 && col == finCol - 1) {
            return m[row][col];
        }
        int oneRight = Integer.MIN_VALUE, twoRight = Integer.MIN_VALUE, oneDown = Integer.MIN_VALUE;
        if (col + 1 < finCol) {
            oneRight = m[row][col] + highestSumTab(m, row, col + 1, tab);
        }
        if (col + 2 < finCol) {
            twoRight = m[row][col] + highestSumTab(m, row, col + 2, tab);
        }
        if (row + 1 < finRow) {
            oneDown = m[row][col] + highestSumTab(m, row + 1, col, tab);
        }
        int result = Math.max(oneRight, Math.max(twoRight, oneDown));
        if (tab[row][col] == Integer.MIN_VALUE) {
            tab[row][col] = result;
        }

        return result;
    }

}
