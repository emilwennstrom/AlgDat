import java.util.Comparator;

public class Edge {

    private int dest;
    private int source;
    private double weight;


    public Edge(int source, int destination) {
        this.source = source;
        this.dest = destination;
        this.weight = Double.POSITIVE_INFINITY;
    }

    public Edge(int source, int destination, double weight) {
        this.source = source;
        this.dest = destination;
        this.weight = weight;
    }

    public boolean equals(Object o) {
        if (o instanceof Edge other) {
            if (other.source == this.source) {
                return other.dest == this.dest;
            }
        }
        return false;
    }


    public int getDest() {
        return dest;
    }

    public int getSource() {
        return source;
    }


    public double getWeight() {
        return weight;
    }


    public int hashCode() {
        return Integer.hashCode(source) * Integer.hashCode(dest);
    }


    public String toString() {
        return "Source: " + source + ", " +
                "Destination: " + dest + ", " +
                "Weight: " + weight + "\n";
    }






}
