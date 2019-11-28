package graph;

import java.util.Iterator;

/**
 * @author singtaifung
 * @since 15-11-2019
 * **/

public class DFS {
	private boolean[] marked;
	private int count;
	
	public DFS(UndirectedGraph graph , int source) {
		marked = new boolean[graph.V()];
		dfs(graph , source);
	}
	
	public void dfs(UndirectedGraph graph , int v) {
		marked[v] = true;
		
		count++;
		for (int w : graph.adjacency(v)) {
			if(!marked[w])
				dfs(graph, w);
			
		}
	}

		
	
		
		
    public boolean marked(int v) {
        return marked[v];
    }
	 public int count() {
	        return count;
	  }
	 
}
