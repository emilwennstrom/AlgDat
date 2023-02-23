import java.util.HashSet;

public class Dijkstras {


    public static void dijkstrasMatrix(Graph graph, int start, int[] pred, double[] dist) {
        // Hämtar storleken på matrisen
        int numV = graph.getNumV();
        // Skapar en mängd för alla noder som ska hanteras
        HashSet<Integer> vMinusS = new HashSet<>(numV);
        // Lägger till alla noder som ska hanteras
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        // alla platser i pred sätts till startnoden
        // alla vikter sätts till de ursprungliga vikterna från start till v.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        while (vMinusS.size() !=  0) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            // Hittar den billigaste vägen från startnoden
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // tar bort den från mängden
            vMinusS.remove(u);

            // Uppdaterar vägarna från noden u till närliggande noder
            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight();
                    // Om vikten mellan start + u och v
                    // är mindre än vikten mellan start och v
                    if (dist[u] + weight < dist[v]) {
                        // uppdatera  vikten
                        dist[v] = dist[u] + weight;
                        // sätt förra noden som u (vägen går via u)
                        pred[v] = u;
                    }
                }
            }


        }
    }


}
