package ds.graph;

import java.util.*;

public class BFS<T> {

    private Map<T , Boolean> visited;
    private Map<T , T> edgeTo;
    private List<T> bfsTraversal;
    private Graph<T> graph;
    private Map<T,Integer> distanceTo;
    private T source;

    BFS(Graph<T> graph, T source) {
        this.graph = graph;
        this.source = source;
        init();
        bfs();
    }

    public void bfs() {

        Queue<T> bfsQueue = new LinkedList<>();

        bfsQueue.offer(source);
        visited.put(source,Boolean.TRUE);
        distanceTo.put(source,0);
        bfsTraversal.add(source);

        while(!bfsQueue.isEmpty()){
            T node = bfsQueue.poll();
            for(T vertex : graph.getAdjacentVertices(node)) {
                if(!visited.get(vertex)){
                    bfsQueue.offer(vertex);
                    edgeTo.put(vertex,node);
                    visited.put(vertex,Boolean.TRUE);
                    bfsTraversal.add(vertex);
                    distanceTo.put(vertex,(distanceTo.get(node)+1));
                }
            }
        }

    }

    public boolean hasPath(T vertex) {

        Boolean hasPath = visited.get(vertex);
        return Objects.isNull(hasPath) ? false : hasPath;
    }

    public Stack<T> getPath(T destination) {

        Stack<T> path = new Stack<>();

        if(hasPath(destination)){
            for(T vertex = destination ; !vertex.equals(source); vertex=edgeTo.get(vertex)) {
                path.push(vertex);
            }
            path.push(source);
        }
        return path;
    }

    private void init() {
        int numberOfVertex = graph.getNumberOfVertex();
        visited = new HashMap<>(numberOfVertex);
        edgeTo = new HashMap<>(numberOfVertex);
        distanceTo = new HashMap<>(numberOfVertex);
        graph.getVertices().forEach(vertex -> visited.put(vertex,Boolean.FALSE));
        bfsTraversal = new ArrayList<>(numberOfVertex + graph.getNumberOfEdge());
    }

    public Map<T, Boolean> getVisited() {
        return visited;
    }

    public Map<T, T> getEdgeTo() {
        return edgeTo;
    }

    public List<T> getBfsTraversal() {
        return bfsTraversal;
    }

    public Map<T, Integer> getDistanceTo() {
        return distanceTo;
    }
}
