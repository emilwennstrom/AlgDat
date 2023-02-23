import java.util.HashSet;

public class Prims {

    public static int[] primsAlgo(Graph graph, int start) {


        int numV = graph.getNumV();
        int[] prev = new int[numV];
        double[] dist = new double[numV];
        HashSet<Integer> vMinusS = new HashSet<>(numV);
        for (int i = 0; i < numV; i++) {
            if (start != i) {
                vMinusS.add(i);
            }
        }

        for (int v : vMinusS) {
            prev[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        prev[start] = -1;

        while (!vMinusS.isEmpty()) {
            double minValue = Double.POSITIVE_INFINITY;
            int u = -1;

            for (int v : vMinusS) {
                if (dist[v] < minValue) {
                    minValue = dist[v];
                    u = v;
                }
            }
            vMinusS.remove(u);

            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight();
                    if (weight < dist[v]) {
                        dist[v] = weight;
                        prev[v] = u;
                    }
                }
            }
        }
        return prev;
    }
}
