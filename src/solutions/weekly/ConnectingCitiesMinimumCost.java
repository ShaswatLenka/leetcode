package solutions.weekly;
import java.util.*;

import utils.graph.SimpleWeightedGraph;
import utils.graph.Pair;

/*
1135: Connecting Cities with Minimum Cost [MED]
 */

public class ConnectingCitiesMinimumCost {

    public int minimumCost(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) {
           adjList.add(new ArrayList<>());
        }
        for (int[] i: connections) {
            adjList.get(i[0]).add(new Pair(i[1], i[2]));
            adjList.get(i[1]).add(new Pair(i[0], i[2]));
        }
        SimpleWeightedGraph g = new SimpleWeightedGraph(n, adjList);
        if (g.isConnected()) {
            return g.MSTCost();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1,2,5}, {1,3,6}, {2,3,1}};

        ConnectingCitiesMinimumCost c = new ConnectingCitiesMinimumCost();
        System.out.println(c.minimumCost(n, connections));
    }
}
