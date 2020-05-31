package ds.graph;

import java.util.*;

public class DFS<T> {

    private Map<T, Boolean> visited;
    private Map<T, T> edgeTO;
    private Graph<T> graph;
    private List<T> dfsTraversal;

    private T source;

    public DFS(Graph<T> graph, T source) {
        this.source = source;
        this.graph = graph;
        init();
        dfs(source);
    }

    public void dfs(T source) {
        visited.put(source,true);
        dfsTraversal.add(source);

        for(T vertex : graph.getAdjacentVertices(source)) {
            if(!visited.get(vertex)){
                dfs(vertex);
            }
            edgeTO.put(vertex,source);
        }
    }

    public boolean hasPath(T vertex) {

        Boolean hasPath = visited.get(vertex);
        return Objects.isNull(hasPath) ? false : hasPath;
    }

    public Stack<T> getPath(T destination) {

        Stack<T> path = new Stack<>();

        if(hasPath(destination)){
            for(T vertex = destination ; !vertex.equals(source); vertex=edgeTO.get(vertex)) {
                path.push(vertex);
            }
            path.push(source);
        }
        return path;
    }

    public void init(){

        final int numberOfVertex = graph.getNumberOfVertex();
        visited = new HashMap<>(numberOfVertex);
        graph.getVertices().forEach(vertex -> visited.put(vertex,false));
        edgeTO = new HashMap<>(numberOfVertex);
        dfsTraversal = new ArrayList<>(numberOfVertex + graph.getNumberOfEdge());
    }

    public Map<T, Boolean> getVisited() {
        return visited;
    }

    public Map<T, T> getEdgeTO() {
        return edgeTO;
    }

    public Graph<T> getGraph() {
        return graph;
    }

    public Iterable<T> getDfsTraversal() {
        return dfsTraversal;
    }

    public T getSource() {
        return source;
    }
}
