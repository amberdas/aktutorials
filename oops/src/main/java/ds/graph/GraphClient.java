package ds.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Amber on 03-12-2018.
 */
public class GraphClient
{
    public static void main(String args[])
    {
        Graph<String> graph = initStringGraph();

        //Uncomment below for basic graph operation

        //basicGraphOperation(graph);

        dfsTraversal(graph,"Delhi");

    }

    private static Graph<String> initStringGraph() {
        List<String> vertices = Arrays.asList(new String[]{"Delhi","Mumbai","Bangalore","Kolkata","Patna","Jamtara","Begusarai"});

        Graph<String> graph = new GraphAdjacencyListImpl(vertices.size());

        graph.addAll(vertices);

        graph.addEdge("Delhi","Mumbai");
        graph.addEdge("Delhi","Bangalore");
        graph.addEdge("Bangalore","Kolkata");
        graph.addEdge("Delhi","Kolkata");
        graph.addEdge("Kolkata","Patna");
        graph.addEdge("Kolkata","Jamtara");
        graph.addEdge("Kolkata","Begusarai");
        graph.addEdge("Goa","MadhyaPradesh");
        graph.addEdge("Kerala","TamilNadu");
        return graph;
    }

    private static void basicGraphOperation(Graph<String> graph) {
        graph.display();

        System.out.println("\nTotal Number Of Edge in Graph: "+graph.getNumberOfEdge());

        graph.removeEdge("Kolkata","Begusarai");

        System.out.println("\nAfter removing edge from Kolkata and Begusarai");

        graph.display();

        System.out.println("Total Number Of Edge in Graph: "+graph.getNumberOfEdge());

        System.out.println("\nBangalore Adjacent Vertex: "+ graph.getAdjacentVertices("Bangalore"));
        System.out.println("\nTotal Number Of Vertex in Graph: "+graph.getNumberOfVertex());
        System.out.println("\nDirect Edge Exist between Kolkata and Patna: "
                +graph.isEdgeExist("Kolkata","Patna"));
        System.out.println("\nDirect Edge Exist between Bangalore and Jamtara: "
                +graph.isEdgeExist("Bangalore","Jamtara"));
        System.out.println("\nDirect Edge Exist between Bangalore and UnkownDestnation: "
                +graph.isEdgeExist("Bangalore","UnkownDestnation"));
    }

    private static void dfsTraversal(Graph<String> graph, String source) {

        DFS<String> dfs = new DFS<>(graph,source);

        System.out.println("DFS Traversal: ");
        System.out.println(dfs.getDfsTraversal());

        System.out.println("Is source: "+source+" has path to Goa: " + dfs.hasPath("Goa"));

        System.out.println("Path from "+source+" to Begusarai:");

        Stack<String> path = dfs.getPath("Begusarai");

        StringBuffer pathString = new StringBuffer();
        while(!path.isEmpty()){
            pathString.append(path.pop()+"->");
        }

        System.out.println(pathString.substring(0,pathString.length()-2));

    }


}
