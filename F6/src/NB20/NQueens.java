package NB20;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    private static final char QUEEN = '♕';
    private static final char SQUARE = '⌑';
    private final int size;
    private final char[][] gameBoard;
    private final ArrayList<char[][]> solvedBoards;
    private final boolean[] neDiagonal;
    private final boolean[] nwDiagonal;

    private final boolean[] queenPosX;
    private final boolean[] queenPosY;
    public NQueens(int n){
        gameBoard = new char[n][n];
        neDiagonal = new boolean[2*n];  // Array for checking diagonal ->^
        nwDiagonal = new boolean[2*n];  // Array for checking diagonal ^<-
        queenPosX = new boolean[n];
        queenPosY = new boolean[n];
        size = n;
        solvedBoards = new ArrayList<>();
        fillBoard();
    }

    public void solveNQueens() {
        solveNQueens(0, 0, 0);
    }
    private void solveNQueens(int posY, int posX, int noOfQueens) {
        if (noOfQueens == size) {
            addToSolvedBoards();
            return;
        }
        if (posY < size && checkPosition(posY, posX)) {
            setQueen(posY, posX);
            solveNQueens(posY + 1, 0, noOfQueens + 1);
            resetPositions(posY, posX);
        }
        if (posX < size - 1) {
            solveNQueens(posY, posX + 1, noOfQueens);
        }
    }

    private void setQueen(int y, int x) {
        gameBoard[y][x] = QUEEN;
        neDiagonal[y + x] = true;
        nwDiagonal[x - y + size-1] = true;
        queenPosY[y] = true;
        queenPosX[x] = true;
    }

    private void addToSolvedBoards() {
        char[][] gameCopy = new char[size][size];
        for (int i = 0; i < size; i++) {
            gameCopy[i] = Arrays.copyOf(gameBoard[i], size);
        }
        solvedBoards.add(gameCopy);
    }
    private boolean checkPosition(int y, int x) {
        if (checkLinear(y, x)) return false;
        return checkDia(y, x);
    }

    private boolean checkLinear(int y, int x) {
        return (queenPosY[y] || queenPosX[x]);
    }

    private boolean checkDia(int y, int x) {
        return (!neDiagonal[y + x] && !nwDiagonal[x - y + size - 1]);
    }

    private void resetPositions(int y, int x) {
        queenPosX[x] = false;
        queenPosY[y] = false;
        neDiagonal[y + x] = false;
        nwDiagonal[x - y + size - 1] = false;
        gameBoard[y][x] = SQUARE;
    }

    public int getSize(){
        return size;
    }

    public String printAllSolved(){
        StringBuilder sb = new StringBuilder();
        for (char[][] boards : solvedBoards) {
            addSpace(sb);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sb.append(boards[i][j]).append("  ");
                }
                sb.append("\n");
            }
            addSpace(sb);
        }
        return sb.toString();
    }

    private void addSpace(StringBuilder sb) {
        int spaces = (size * 2) + (size / 2);
        sb.append("=".repeat(Math.max(0, spaces)));
        sb.append("\n");
    }

    public int getNoOfSolutions() {
        return solvedBoards.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(gameBoard[i][j]).append("  ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void fillBoard() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(gameBoard[i], SQUARE);
        }
    }

   /* private boolean checkX(int y) {
        for (int i = 0; i < size; i++) {
            if (gameBoard[y][i] == QUEEN)
                return false;
        }
        return true;
    }

    private boolean checkDiagonal(int y, int x) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i + j == x + y) {
                    if (gameBoard[j][i] == QUEEN) return false;
                }
                if ((i - j) == x - y) {
                    if (gameBoard[j][i] == QUEEN) return false;
                }
            }
        }
        return true;
    }

    private boolean checkY(int x) {
        for (int i = 0; i < size; i++) {
            if (gameBoard[i][x] == QUEEN)
                return false;
        }
        return true;
    }*/


}
