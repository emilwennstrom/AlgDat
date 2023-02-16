package NB19;

import java.util.Arrays;

public class Brickspel {

    private enum bricks {WHITE, BLACK};

    final static int depth = 16;

    final static int[] intSolve = {2, 2, 2, 0, 1, 1, 1};

    public static void brickStart() {
       int[] board = {1, 1, 1, 0, 2, 2, 2};
       int empty = board.length / 2;
       int noOfMoves = 0;
       bricks(board, empty, noOfMoves);
       System.out.println(Arrays.toString(board));
    }

    private static boolean bricks(int[] board, int empty, int noOfMoves) {
       if (depth == noOfMoves) return false;
       if (checkArr(board)) return true;
       if (empty + 1 < board.length && board[empty + 1] == 2) {
           switchPlaces(board, empty, empty + 1);
           if (bricks(board, empty + 1, noOfMoves + 1)) {
               System.out.print(empty + "-->"+(empty+1)+", ");
               return true;
           } else {
               switchPlaces(board, empty + 1, empty);
           }
       }
        if (empty + 2 < board.length && board[empty + 2] == 2) {
            switchPlaces(board, empty, empty + 2);
            if (bricks(board, empty + 2, noOfMoves + 1)) {
                System.out.print(empty + "-->"+(empty+2)+", ");
                return true;
            } else {
                switchPlaces(board, empty + 2, empty);
            }
        }
        if (empty - 2 >= 0 && board[empty - 2] == 1) {
            switchPlaces(board, empty, empty - 2);
            if (bricks(board, empty - 2, noOfMoves + 1)) {
                System.out.print(empty + "-->"+(empty-2)+", ");
                return true;
            } else {
                switchPlaces(board, empty - 2, empty);
            }
        }
        if (empty - 1 >= 0 && board[empty - 1] == 1) {
            switchPlaces(board, empty, empty - 1);
            if (bricks(board, empty - 1, noOfMoves + 1)) {
                System.out.print(empty + "-->"+(empty-1)+", ");
                return true;
            } else {
                switchPlaces(board, empty - 1, empty);
            }
        }
       return false;
    }

    private static void switchPlaces(int[] board, int empty, int next) {
        board[empty] = board[next];
        board[next] = 0;
    }
    private static boolean checkArr(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != intSolve[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        brickStart();
    }


}
