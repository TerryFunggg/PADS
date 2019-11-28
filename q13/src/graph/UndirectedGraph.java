package graph;

/**
 * @author singtaifung
 * @since 15-11-2019
 * **/

import java.util.LinkedList;


public class UndirectedGraph {
	private int V; // number of vertices
	private int E; // number of edges
	private LinkedList<Integer>[] adjList; // adjacency list

	public UndirectedGraph(int size) {
		if(size == 0) throw new IllegalArgumentException();
		this.V = size;
		this.E = 0;
		this.adjList = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adjList[v] = new LinkedList<Integer>();
		}

	}

	public int V() {
		return V;
	}

    public int E(){
		return E;
    }

    public void addEdge(int v , int w){
    	if(v < 0 || v >= V && w < 0 || w >= V)
    		throw new IllegalArgumentException("Must between 0 and " + (V -1));
		adjList[v].add(w);
		adjList[w].add(v);
		E++;
    }

    public Iterable<Integer> adjacency(int v){
    	if(v < 0 || v >= V)
    		throw new IllegalArgumentException("Must between 0 and " + (V -1));
		return adjList[v];
    }
    
    @Override
    public String toString() {
    	String r = V + " vertices ， " + E + " edges \n" ;
    	for (int i = 0; i < V; i++) {
    		r += i + ": ";
    		for(int w : adjList[i]) {
    			r += w + " ";
    		}
    		r += "\n";
			
		}
    	return r;
    }
}
