package Uppg7;

public class PuzzlePiece {

    private final Point anchor;
    private final Point c2;
    private final Point c3;


    public PuzzlePiece(Point anchor, Point startPos2, Point startPos3) {
        this.anchor = anchor;
        c2 = startPos2;
        c3 = startPos3;
    }

    public PuzzlePiece(PuzzlePiece p) {
        anchor = new Point(p.anchor.getRow(), p.anchor.getCol());
        c2 = new Point(p.c2.getRow(), p.c2.getCol());
        c3 = new Point(p.c3.getRow(), p.c3.getCol());
    }

    public int getMaxCol() {
        return Math.max(Math.max(anchor.getCol(), c2.getCol()), c3.getCol());
    }

    public void moveRight() {
        anchor.changeCol(1);
        c2.changeCol(1);
        c3.changeCol(1);
    }
    public Point getAnchor() {
        return anchor;
    }

    public Point getC2() {
        return c2;
    }

    public Point getC3() {
        return c3;
    }

}
