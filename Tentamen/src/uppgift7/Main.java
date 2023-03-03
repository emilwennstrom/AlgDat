package uppgift7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

public class Main {

    public static void main(String[] args){
        char[][] board = {  {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ','S',' ',' ','X','X','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','M','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};
        char[][] b2 =   {   {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ','S',' ',' ','X','X','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','M','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};
        System.out.println(shortestRoute(board));
        System.out.println(shortestRoute(b2));
    }

    private static int shortestRoute(char[][] board) {
        Position start = getCharPos(board, 'S');
        Position end = getCharPos(board, 'M');
        if (start == null || end == null) throw new IllegalStateException();
        Position next, current;

        int[][] noOfMoves = new int[board.length][board[0].length];
        for (int i = 0; i < noOfMoves.length; i++) {
            for (int j = 0; j < noOfMoves[0].length; j++) {
                if (board[i][j] == 'X') noOfMoves[i][j] = -2;
                else noOfMoves[i][j] = -1;
            }
        }
        noOfMoves[start.getRow()][start.getCol()] = 0;

        Queue<Position> positions = new ArrayDeque<>();
        positions.offer(start);
        while(!positions.isEmpty()) {
            current = positions.poll();
            for (int i = 0; i < 4; i++) {
                next = getPosition(current, i, noOfMoves);
                if (next != null) {
                    if (next.equals(end))
                        return 1 + noOfMoves[current.getRow()][current.getCol()];
                    positions.offer(next);
                    noOfMoves[next.getRow()][next.getCol()] = 1 + noOfMoves[current.getRow()][current.getCol()];
                }
            }
        }
        return -1;
    }


    private static Position getPosition(Position current, int direction, int[][] noOfMoves) {
        int row = current.getRow();
        int col = current.getCol();
        switch (direction) {
            case 0 -> {
                while (noOfMoves[row][col - 1] != -2) { //Go left
                    col--;
                }
            }
            case 1 -> {
                while (noOfMoves[row][col + 1] != -2) {  //Go right;
                    col++;
                }
            }
            case 2 -> {
                while (noOfMoves[row - 1][col] != -2) {// Go down
                    row--;
                }
            }
            case 3 -> {
                while (noOfMoves[row + 1][col] != -2) {
                    row++;                              // go up
                }
            }
        }
        if (noOfMoves[row][col] == -1) return new Position(row, col);
        return null;
    }




    private static Position getCharPos(char[][] board, char c) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == c) return new Position(i, j);
            }
        }
        return null;
    }


    private static class Position {

        int row;
        int col;
        public Position(int row, int col) {
            this.col = col;
            this.row = row;
        }


        public boolean comparePos(int row, int col) {
            return this.row == row && this.col == col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

}
