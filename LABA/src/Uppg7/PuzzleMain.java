package Uppg7;

public class PuzzleMain {

    public static void main(String[] args) {
        PuzzleBoard board;
        board = new PuzzleBoard(0, 2, 5);
        System.out.println(board.solveBoard());


        /*for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board = new PuzzleBoard(i, j, 5);
                System.out.println(board.solveBoard());
            }
        }*/
    }
}
