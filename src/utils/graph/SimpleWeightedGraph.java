package utils.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Creates a weighted Graph with an adjacency list representation where each vertex is represented
 * as Integer in range [1, N]. where N is the total number of vertices. To also store weight info
 * in the adj list, we use Pair to store node and weight together.
 */
public class SimpleWeightedGraph {
    ArrayList<ArrayList<Pair>> adjList; // 1 -> {Pair(2,5), Pair(3,6)} means Node 1 is connected to node 2 and 3 with weights 5 and 6
    int V;
    boolean[] visited;
    int[] ccNumArray; // connected components

    public SimpleWeightedGraph(int V, ArrayList<ArrayList<Pair>> adjList) {
        this.V = V;
        this.adjList = adjList;
        this.visited = new boolean[V+1];
        this.ccNumArray = new int[V+1];
    }

    private void explore(int vertex, boolean[] visited, int ccNum) {
        visited[vertex] = true;
        ccNumArray[vertex] = ccNum;
        for (Pair nbr: this.adjList.get(vertex)) {
            if (!visited[nbr.node]) {
                explore(nbr.node, visited, ccNum);
            }
        }
    }

    /**
     * Performs a simple dfs with counting the connected components
     */
    public void dfs() {
       int ccNum = 1;
       for (int i = 1; i <= this.V; i++) {
           if (!visited[i]) {
               this.explore(i, visited, ccNum);
               ccNum++;
           }
       }
    }

    /**
     * Returns true if the graph is connected
     * @return
     */
    public boolean isConnected() {
        this.dfs();
        for (int i = 1; i <= this.V; i++) {
           if(ccNumArray[i] > 1) return false;
        }
        return true;
    }

    /**
     * Returns the cost of the Minimum Spanning Tree using Prim's Algorithm
     */
   public int MSTCost() {
       PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
       boolean[] visited = new boolean[this.V + 1];
       int mstCost = 0;
       pq.add(new Pair(1, 0)); // just to initialize the queue without adding weight
       while(!pq.isEmpty()) {
           Pair best = pq.poll();
           int to = best.node;
           int weight = best.weight;
           if (visited[to]) {
               // discard the edge and continue
               continue;
           }
           // otherwise take the current edge
           mstCost += weight;
           visited[to] = true;

           // add the new edges to the queue
           for (Pair p: this.adjList.get(to)) {
               if (!visited[p.node]) {
                   pq.add(p);
               }
           }
       }
      return mstCost;
   }

}
