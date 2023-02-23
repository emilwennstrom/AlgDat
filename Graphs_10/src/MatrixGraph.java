import java.io.*;
import java.util.*;

public class MatrixGraph extends AbstractGraph {

    private final double[][] edges;

    private int[] pred;
    private double[] dist;

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new double[numV][numV];
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                edges[i][j] = Double.POSITIVE_INFINITY;
            }
        }
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

    public String dijkstrasTwoPoints(int start, int stop) {
        int numV = this.getNumV();
        pred = new int[numV];
        dist = new double[numV];
        HashSet<Integer> vMinusS = new HashSet<>(numV);
        // Lägger till alla noder som ska processas
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = this.getEdge(start, v).getWeight();
        }
        while (vMinusS.size() !=  0) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            if (u == stop) {
                StringBuilder sb = new StringBuilder();
                Stack<Integer> strings = new Stack<>();
                sb.append("Shortest path between ");
                sb.append(start).append(" and ").append(stop).append(" is:\n");
                int i = stop;
                while (i != start) {
                    strings.push(pred[i]);
                    i = pred[i];
                }
                while (!strings.empty()) {
                    sb.append(strings.pop());
                    sb.append("->");
                }
                sb.append(stop);
                sb.append(" with a cost of ").append(dist[stop]);
                return sb.toString();
            }
            vMinusS.remove(u);
            for (int v : vMinusS) {
                if (this.isEdge(u, v)) {
                    double weight = this.getEdge(u, v).getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(pred));
        System.out.println(Arrays.toString(dist));

        return "";
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getNumV(); i++) {
            Iterator<Edge> itr = this.edgeIterator(i);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                if (Double.isFinite(edge.getWeight())) {
                    sb.append("Node ").append(i);
                    sb.append(" to Node ").append(edge.getDest()).append(" :: ");
                    sb.append("Weight is ").append(edge.getWeight()).append("\n");
                }

            }
        }
        return sb.toString();
    }


    public static MatrixGraph readMatrixFromFile(String fileName) throws FileNotFoundException {
        File file = null;
        Scanner scan = null;
        int numV;
        boolean isDirected;
        MatrixGraph m;
        try {
            file = new File(fileName);
            scan = new Scanner(file);
            numV = scan.nextInt();
            isDirected = scan.nextBoolean();
            m = new MatrixGraph(numV, isDirected);
            int row = 0, col = 0;
            while (scan.hasNext()) {
                String line = scan.next();
                if (!line.equals("")) {
                    if (line.equals("X")) {
                        m.edges[row][col] = Double.POSITIVE_INFINITY;
                    } else {
                        m.edges[row][col] = Double.parseDouble(line);
                    }
                    row++;
                    if (row == numV) {
                        row = 0;
                        col++;
                    }
                }
            }


        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        finally {
            if (scan != null) {
                scan.close();
            }
        }
        return m;
    }


    public void writeMatrixToFile(String fileName) throws IOException {
        FileWriter fw = null;
        PrintWriter pw = null;
        int verts = getNumV();
        try {
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            pw.println(this.getNumV());
            pw.println(this.isDirected());

            for (int i = 0; i < verts; i++) {
                for (int j = 0; j < verts; j++) {
                    if (edges[i][j] == Double.POSITIVE_INFINITY) {
                        pw.print("X");
                    } else {
                        pw.print(edges[i][j]);
                    }
                    pw.print(" ");
                }
                pw.println();
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (fw != null) {
                fw.close();
            }
            if (pw != null) {
                pw.close();
            }
        }
    }
}
