import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

    private double[][] edges;

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new double[numV][numV];
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                edges[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }


    public MatrixGraph(int numV, boolean directed, String fileName) {
        this(numV, directed);

    }


   public boolean isEdge(int source, int dest) {
        return edges[source][dest] != Double.POSITIVE_INFINITY;
   }

   public Edge getEdge(int source, int dest) {
        if (edges[source][dest] != Double.POSITIVE_INFINITY) {
            return new Edge(source, dest, edges[source][dest]);
        } else {
            return new Edge(source, dest, Double.POSITIVE_INFINITY);
        }
   }

   public void insert (Edge edge) {
        int source = edge.getSource();
        int dest = edge.getDest();
        double weight = edge.getWeight();
        edges[source][dest] = weight;
        if (!isDirected()) {
            edges[dest][source] = weight;
        }
   }

    public Iterator<Edge> edgeIterator(int source) {
        return new Itr(source);
    }


    private class Itr implements Iterator<Edge> {

        int start;
        int dest;

        public Itr(int source) {
            this.start = source;
        }

        @Override
        public boolean hasNext() {
            if (dest < edges.length){
                dest++;
                return true;
            }
            return false;
        }

        @Override
        public Edge next() {
            return new Edge(start, dest - 1, edges[start][dest - 1]);
        }
    }


    private void readMatrixFromText(String fileName) {
        
    }

}
