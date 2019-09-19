package com.graphalgo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ankitku
 * Adjacency List graph
 */
public class Graph 
{
	private int V;
	private LinkedList<Integer> adj[];
	Graph(int ver)
	{
		V = ver;
		adj = new LinkedList[ver];
		
		for(int i = 0; i<ver;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int ver, int w)
	{
		adj[ver].add(w);
	}
	
	public static void main(String[] args) 
	{
		Graph g = new Graph(4);
		
	    g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        System.out.println("Starting of BFS from vertex 2");
	  
        g.startBFS(2);
        
        System.out.println();
        
        System.out.println("Starting of DFS");
        
        g.startDFS();
	}

	private void startDFS() 
	{
		//memo to create the visited ver
		
		boolean visited[] = new boolean[V];
		
		for(int i = 0 ; i < V ; i++)
		{
			if(visited[i] == false)
			{
				DFSUtil(i,visited);
			}
		}
		
		
	}

	private void DFSUtil(int v, boolean[] visited) {
		visited [v] = true;
		
		System.out.print(v+" ");
		
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				DFSUtil(n, visited);
			}
		}
		
	}

	private void startBFS(int s) 
	{
		boolean visited [] = new boolean[V];
		
		//queue for the BFS
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		//mark the current node as visited and enqueue it
		
		visited[s] = true;
		
		queue.add(s);
		
		while(queue.size()!=0)
		{
			s = queue.poll();
			System.out.print(s +" ");
			
		
		
		Iterator<Integer> i = adj[s].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				visited[n] = true;
				queue.add(n);
			}
		}
		
		
		}
		
	}

}
