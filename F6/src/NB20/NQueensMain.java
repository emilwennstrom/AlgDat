package NB20;

public class NQueensMain {
    public static void main(String[] args) {

        NQueens queens = new NQueens(1);
        queens.solveNQueens();
        //System.out.println(queens.printAllSolved());      // printar alla lösningar
        System.out.println("Antal damer: " + queens.getSize());
        System.out.println("Lösningar: " + queens.getNoOfSolutions());
    }
}
