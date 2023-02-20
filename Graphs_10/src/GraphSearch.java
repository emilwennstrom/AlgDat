import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

    public static int[] breadthFirstSearch(Graph graph, int start) {
        Queue<Integer> theQueue = new LinkedList<>();
        int[] parent = new int[graph.getNumV()];
        Arrays.fill(parent, -1);

        boolean[] identified = new boolean[graph.getNumV()];
        identified[start] = true;
        theQueue.offer(start);
        while (!theQueue.isEmpty()){
            int current = theQueue.remove();
            Iterator<Edge> itr = graph.edgeIterator(start);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                if (edge.getWeight() != Double.POSITIVE_INFINITY) {
                    int neighbor = edge.getDest();
                    if (!identified[neighbor]) {
                        identified[neighbor] = true;
                        theQueue.offer(neighbor);
                        parent[neighbor] = current;
                    }
                }
            }
        }
        return parent;
    }
}
