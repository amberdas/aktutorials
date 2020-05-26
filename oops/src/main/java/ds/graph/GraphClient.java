package ds.graph;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Amber on 03-12-2018.
 */
public class GraphClient
{
    public static void main(String args[])
    {
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
}
