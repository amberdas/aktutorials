package ds.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphAdjacencyListImpl<T>  implements Graph<T> {

    private final static int DEFAULT_SIZE =16;
    private Map<T, LinkedList<T>> vertices;
    private int numberOfEdge;

    GraphAdjacencyListImpl(){
        this(DEFAULT_SIZE);
    }

    GraphAdjacencyListImpl(int numberOfVertex) {
        vertices = new HashMap<>(numberOfVertex);
    }

    @Override
    public void add(T vertex) {
        vertices.put(vertex, new LinkedList<>());
    }

    @Override
    public void addAll(Collection<T> collection) {
        collection.forEach(vertex -> add(vertex));
    }

    @Override
    public boolean addEdge(T sourceVertex, T destinationVertex) {
        if(isVertexExist(sourceVertex) && isVertexExist(destinationVertex)) {
            vertices.get(sourceVertex).add(destinationVertex);
            vertices.get(destinationVertex).add(sourceVertex);
            numberOfEdge++;
            return true;
        }
        return false;
    }

    public boolean removeEdge(T sourceVertex, T destinationVertex) {
        if(isEdgeExist(sourceVertex,destinationVertex)) {

            vertices.get(sourceVertex).remove(destinationVertex);
            vertices.get(destinationVertex).remove(sourceVertex);
            numberOfEdge-=2;
            return true;
        }
        return false;
    }

    @Override
    public Iterable<T> getAdjacentVertices(T vertex) {
        return vertices.get(vertex);
    }

    @Override
    public int getNumberOfVertex() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdge() {
        return this.numberOfEdge;
    }

    @Override
    public boolean isEdgeExist(T sourceVertex, T destinationVertex) {
        if(isVertexExist(sourceVertex) && isVertexExist(destinationVertex)) {
            return vertices.get(sourceVertex).contains(destinationVertex)
                    && vertices.get(destinationVertex).contains(sourceVertex);
        }
        return false;
    }

    @Override
    public void display() {

        System.out.println("Vertex Wise display of Graph:");

        vertices.forEach((vertex, adjacentVertices) -> {
            System.out.print("Vertex : "+vertex);
            adjacentVertices.forEach(node -> System.out.print(" -> " + node));System.out.println();} );
    }

    public Iterable<T> getVertices() {
        return vertices.keySet();
    }

    private boolean isVertexExist(T vertex) {
        return vertices.get(vertex)!=null;
    }

}
