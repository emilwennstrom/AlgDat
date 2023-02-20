import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Edge AB = new Edge(0, 1, 10);
        Edge BA = new Edge(1, 2, 30);

        Edge DA = new Edge(0,3, 60);
        Edge AD = new Edge(3, 2,5 );
        Edge DE = new Edge(3, 4, 5);



        MatrixGraph matrixGraph = new MatrixGraph(5, false);
        ListGraph listGraph = new ListGraph(5, false);


        matrixGraph.insert(AB);
        matrixGraph.insert(BA);
        matrixGraph.insert(DA);
        matrixGraph.insert(DE);
        matrixGraph.insert(AD);


        listGraph.insert(AB);
        listGraph.insert(BA);
        listGraph.insert(DA);
        listGraph.insert(DE);
        listGraph.insert(AD);


        Iterator<Edge> itr = matrixGraph.edgeIterator(0);
        while (itr.hasNext()) {
            Edge edge = itr.next();
            if (edge.getWeight() != Double.POSITIVE_INFINITY)
                System.out.print(edge.getWeight() + " ");
        }


        System.out.println(Arrays.toString(GraphSearch.breadthFirstSearch(matrixGraph, 0)));

        int[] pred = new int[matrixGraph.getNumV()];
        double[] dist = new double[matrixGraph.getNumV()];

        Dijkstras.dijkstrasMatrix(matrixGraph, 0, pred, dist);

        System.out.println(Arrays.toString(pred));
        System.out.println(Arrays.toString(dist));



        System.out.println("Hello world!");
    }
}