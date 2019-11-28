import graph.DFS;
import graph.UndirectedGraph;

public class MainDrive {

	public static void main(String[] args) {
		UndirectedGraph graph = new UndirectedGraph(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 3);
		
		

		System.out.println(graph);

		
		DFS dfs = new DFS(graph, 0);
		
		for (int v = 0; v < graph.V(); v++) {
            if (dfs.marked(v))
            	System.out.print(v + " ");
        }

		System.out.println();
        if (dfs.count() != graph.V()) 
        	System.out.println("NOT connected");
        else                         
        	System.out.println("connected");
    }

		
	

}
