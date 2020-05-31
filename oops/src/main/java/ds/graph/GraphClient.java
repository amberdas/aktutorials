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

        dfsTraversal(graph,"Delhi","Begusarai","Goa","Begusarai");

        Graph<String> linkedinConnectionGraph = initLinkedinConnectionGraph();
        dfsTraversal(linkedinConnectionGraph,"Amber","Amit Jha","Random","Prabhat");

    }

    private static Graph<String> initLinkedinConnectionGraph() {

        List<String> vertices = Arrays.asList(new String[]{"Amber","Pallav","Akash","Vivek","Prabhat","Haritabh","Vikrant",
        "Amit","Yede","Naveen","Abhishek","Rahul","Amit Jha","Newton","Ayush"});

        Graph<String> graph = new GraphAdjacencyListImpl(vertices.size());

        graph.addAll(vertices);

        graph.addEdge("Amber","Haritabh");
        graph.addEdge("Amber","Akash");
        graph.addEdge("Amber","Pallav");
        graph.addEdge("Amber","Vivek");
        graph.addEdge("Amber","Prabhat");
        graph.addEdge("Amber","Vikrant");
        graph.addEdge("Akash","Amit");
        graph.addEdge("Akash","Newton");
        graph.addEdge("Newton","Ayush");
        graph.addEdge("Prabhat","Yede");
        graph.addEdge("Haritabh","Naveen");
        graph.addEdge("Haritabh","Abhishek");
        graph.addEdge("Haritabh","Rahul");
        graph.addEdge("Naveen","Amit Jha");
        graph.addEdge("Vivek","Amit Jha");
        graph.addEdge("Akash","Pallav");

        return graph;
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

    private static void dfsTraversal(Graph<String> graph, String source, String destination1, String destination2, String destination3) {

        DFS<String> dfs = new DFS<>(graph,source);

        System.out.println("DFS Traversal: ");
        System.out.println(dfs.getDfsTraversal());

        System.out.println("Is "+source+" has connection to "+destination2+":" + dfs.hasPath(destination2));
        System.out.println("Is "+source+" has connection to "+destination3+":" + dfs.hasPath(destination3));

        System.out.println("Path from "+source+" to "+destination1+":");

        Stack<String> path = dfs.getPath(destination1);

        StringBuffer pathString = new StringBuffer();
        while(!path.isEmpty()){
            pathString.append(path.pop()+"->");
        }

        System.out.println(pathString.substring(0,pathString.length()-2));

    }


}
