package utils.graph;

import java.util.ArrayList;
import java.util.Collections;


/**
 * SimpleGraph: Graph where the vertices are integers
 */
public class SimpleGraph {
    private ArrayList<ArrayList<Integer>> adjList;
    private Integer NumberOfVertices;
    private ArrayList<Boolean> visited;
    private ArrayList<Integer> ccNumArray;

    /**
     * Creates Adjacency List from # of vertices(n) and an array of edges where edge[i] = [ai, bi],
     * denotes that there exists an undirected edge between ai and bi.
     * vertices numbering starts from 1
     */
    public static ArrayList<ArrayList<Integer>> createAdjListForIntegerVertices(int[][] edges, int n) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i<n+1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    public SimpleGraph(ArrayList<ArrayList<Integer>> adjList, Integer numberOfVertices) {
        this.adjList = adjList;
        NumberOfVertices = numberOfVertices;
        this.visited = new ArrayList<>(Collections.nCopies(numberOfVertices+1, false));
        this.ccNumArray = new ArrayList<>(Collections.nCopies(numberOfVertices+1, 0));
    }

    public void explore(int vertex, ArrayList<Boolean> visited, int ccNum) {
       visited.set(vertex, true);
       this.ccNumArray.set(vertex, ccNum);
       for (int nbr: this.adjList.get(vertex)) {
          if (!visited.get(nbr)) {
              explore(nbr, visited, ccNum);
          }
       }
    }

    public void dfs() {
        int ccNum = 1;
        for (int i = 1; i <= this.NumberOfVertices; i++) {
            if (!visited.get(i)) {
                explore(i, visited, ccNum);
                ccNum++;
            }
        }
    }

    public void setConnectedComponents() {
        int ccNum = 1;
        for (int i = 0; i < this.NumberOfVertices; i++) {
            if (!visited.get(i)) {
                explore(i, visited, ccNum);
                ccNum++;
            }
        }
    }

    public ArrayList<Integer> getCCNumArray() {
       return this.ccNumArray;
    }
}
