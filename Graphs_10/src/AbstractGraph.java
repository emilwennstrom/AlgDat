import java.util.Iterator;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {

    private int numV;
    private boolean directed;

    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    @Override
    public int getNumV() {
        return numV;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void insert(Edge edge) {

    }

    @Override
    public boolean isEdge(int source, int dest) {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }


    public void loadEdgesFromFile(Scanner scan) {
        // Exercise
    }

    public static Graph createGraph(Scanner scan, boolean isDirected, String type) {
        int numV = scan.nextInt();
        AbstractGraph returnValue = null;
        if (type.equalsIgnoreCase("Matrix")) {
            returnValue = new MatrixGraph(numV, isDirected);
        } else if (type.equalsIgnoreCase("List")) {
            returnValue = new ListGraph(numV, isDirected);
        } else {
            throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }


}
