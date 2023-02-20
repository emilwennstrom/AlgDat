

/**  Interface to specify a Graph ADT. A graph is a set of
       vertices and a set of edges. Vertices are represented
       by integers from 0 to n - 1. Egdes are ordered pairs of
       vertices. Each implementation of the Graph interface should
       provide a constructor that specifies the number of vertices
       and whether the graph is directed.
    */

import java.util.*;
public interface Graph {

    /**
     * Return the number of vertices
     * @return The number of vertices
     */
    int getNumV();

    /**
     * Determine whether this is a directed graph
     * @return true if this is a weighted graph
     */
    boolean isDirected();

    /**
     * Insert a new edge into the graph
     */

    void insert (Edge edge);


    /**
     * Determine whether an edge exists
     * @param source The source vertex
     * @param dest  The destination vertex
     * @return true if there is and edge from source to dest
     */
    boolean isEdge(int source, int dest);


    /**
     * Get the edge between two vertices
     * @param source The source vertex
     * @param dest The destination vertex
     * @return The Edge between these two vertices
     * or and Edge with a weight of Double.POSITIVE_INFINITY
     * if there is no Edge.
     */
    Edge getEdge(int source, int dest);


    /**
     * Return an iterator to the edges connected
     * to a given vertex
     * @param source The source vertex
     * @return An Iterator<Edge> to the vertices connected
     * to the source
     */
    Iterator<Edge> edgeIterator(int source);

}