package Uppg7;

import java.util.ArrayList;
import java.util.Stack;

public class PuzzleBoard {

    private char[] pieceDesign;
    public static int totCounter = 0;
    private static final int numberOfPuzzlePieces = 4;
    private char[][] board;
    private final int size;
    PuzzlePiece[] pieces;
    private final Stack<PuzzlePiece[]> positions;
    private int noOfSolutions;
    private final ArrayList<char[][]> solvedBoards;
    private final int xRow, xCol;
    private int counter;


    public PuzzleBoard(int row, int column) {
        counter = 0;
        this.xRow = row;
        this.xCol = column;
        setPieceDesign();
        this.size = 5;
        positions = new Stack<>();
        createStartingBoard(row, column);
        createPieces(0);
        solvedBoards = new ArrayList<>();
    }

    public String solveBoard() {
        noOfSolutions = 0;
        solveBoard(0);
        return printSolvedBoards();
    }

    private void solveBoard(int row) {
        totCounter++;
        counter++;
        if (row == size - 1) {
            if (checkBoard()) {
                addSolvedBoard();
                noOfSolutions++;
                return;
            }
        }
        if (checkRow(row)){
            positions.push(pieces);
            createPieces(row + 1);
            moveToNextPosition();
            solveBoard(row + 1);
            pieces = positions.pop();
        }

        for (int i = 0; i < numberOfPuzzlePieces; i++){
            if (spotIsBlock(pieces[i])) {
                moveToNextPosition();
            }
            if (checkPiece(pieces[i])) {
                setPiece(pieces[i], pieceDesign[i]);
                positions.push(copyPieces());
                moveToNextPosition();
                solveBoard(row);
                pieces = positions.pop();
                unSetPiece(pieces[i]);
            }
        }
    }

    private boolean spotIsBlock(PuzzlePiece piece){
        int row = piece.getAnchor().getRow();
        int col = piece.getAnchor().getCol();
        if (row >= size || col >= size) {
            return false;
        }
        return board[row][col] == 'X';

    }

    private boolean checkRow(int row) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 'W') return false;
        }
        return true;
    }
    private void moveToNextPosition() {
       for (int i = 0; i < numberOfPuzzlePieces; i++) {
           int maxCol = pieces[i].getMaxCol();
           int anchRow = pieces[i].getAnchor().getRow();
           int anchCol = pieces[i].getAnchor().getCol();
           while (maxCol < size && board[anchRow][anchCol] != 'W') {
               pieces[i].moveRight();
               anchCol = pieces[i].getAnchor().getCol();
               maxCol = pieces[i].getMaxCol();
           }
       }
    }
    private PuzzlePiece[] copyPieces() {
        PuzzlePiece[] copy = new PuzzlePiece[4];
        for (int i = 0; i < 4; i++) {
            copy[i] = new PuzzlePiece(pieces[i]);
        }
        return copy;
    }
    private void createPieces(int row) {
        pieces = new PuzzlePiece[numberOfPuzzlePieces];
        pieces[0] = new PuzzlePiece(new Point(row, 0), new Point(row + 1, 0), new Point(row + 1, 1));
        pieces[1] = new PuzzlePiece(new Point(row, 0), new Point(row, 1), new Point(row + 1, 1));
        pieces[2] = new PuzzlePiece(new Point(row, 0), new Point(row + 1, 0), new Point(row, 1));
        pieces[3] = new PuzzlePiece(new Point(row, 0), new Point(row + 1, 0), new Point(row + 1, -1));
    }
    private boolean checkBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == 'W') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkPiece(PuzzlePiece piece) {
        int row1 = piece.getAnchor().getRow();
        int col1 = piece.getAnchor().getCol();

        if (row1 >= size || col1 >= size || board[row1][col1] != 'W') {
            return false;
        }

        int row2 = piece.getC2().getRow();
        int col2 = piece.getC2().getCol();
        int row3 = piece.getC3().getRow();
        int col3 = piece.getC3().getCol();
        if (row2 >= size || row3 >= size || col2 >= size || col3 >= size || col2 < 0 || col3 < 0)
            return false;
        return board[row2][col2] == 'W' && board[row3][col3] == 'W';
    }

    public void setPiece(PuzzlePiece piece, char c) {
        board[piece.getAnchor().getRow()][piece.getAnchor().getCol()] = c;
        board[piece.getC2().getRow()][piece.getC2().getCol()] = c;
        board[piece.getC3().getRow()][piece.getC3().getCol()] = c;
    }

    public void unSetPiece(PuzzlePiece piece) {
        board[piece.getAnchor().getRow()][piece.getAnchor().getCol()] = 'W';
        board[piece.getC2().getRow()][piece.getC2().getCol()] = 'W';
        board[piece.getC3().getRow()][piece.getC3().getCol()] = 'W';
    }

    private void createStartingBoard(int row, int column) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 'W';
            }
        }
        board[row][column] = 'X';
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(board[i][j]).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void addSolvedBoard() {
        char[][] copy = new char[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, size);
        }
        solvedBoards.add(copy);
    }

    private void setPieceDesign() {
        pieceDesign = new char[4];
        pieceDesign[0] = '⌊';
        pieceDesign[1] = '⌉';
        pieceDesign[2] = '⌈';
        pieceDesign[3] = '⌋';
    }


    public String printSolvedBoards(){
        StringBuilder sb = new StringBuilder();
        sb.append("Block at [").append(xRow).append("]").append("[").append(xCol).append("]").append("\n");
        sb.append("Number of function calls: ").append(counter).append("\n");
        if (solvedBoards.size() == 0) {
            sb.append("No solutions").append("\n");
            return sb.toString();
        }
        int no = 1;
        sb.append("Total solutions: ").append(noOfSolutions).append("\n");
        for(char[][] c : solvedBoards) {
            sb.append("Solution ").append(no++).append("\n");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sb.append(c[i][j]).append("  ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

