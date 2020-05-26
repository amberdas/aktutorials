package ds.graph;

import java.util.Collection;

/**
 * Created by Amber on 26-05-2020.
 */
public interface Graph<T> {

    void add(T vertex);
    void addAll(Collection<T> collection);
    boolean addEdge(T sourceVertex, T destinationVertex);
    boolean removeEdge(T sourceVertex, T destinationVertex);
    Iterable getAdjacentVertices(T vertex);
    int getNumberOfVertex();
    int getNumberOfEdge();
    boolean isEdgeExist(T sourceVertex, T destinationVertex);
    void display();

}
