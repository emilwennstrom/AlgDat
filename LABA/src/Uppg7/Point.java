package Uppg7;

public class Point {

    private final int row;
    private int col;


    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void changeCol(int i) {
        col += i;
    }

    public int getCol() {
        return col;
    }
}
