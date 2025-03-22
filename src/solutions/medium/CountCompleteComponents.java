package solutions.medium;

import utils.graph.SimpleGraph;
import java.util.ArrayList;
import java.util.*;
/**
 * Leetcode 2685: Count the number of Complete Components
 *  Algorithm: Find # of vertices and # of edges in a CC and check if #E = (#V * #(V-1))/2
 *  TC = O(V+E)
 */

public class CountCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> adjList = SimpleGraph.createAdjListForIntegerVertices(edges, n);
        SimpleGraph g = new SimpleGraph(adjList, n);
        g.setConnectedComponents();
        ArrayList<Integer> ccNumArray = g.getCCNumArray();

        Map<Integer, Integer> ccNumToNumberOfEdges = new HashMap<>();
        Map<Integer, Integer> ccNumToNumberOfVertices = new HashMap<>();

        for (int i=0; i<n; i++) {
            int ccNum = ccNumArray.get(i);
            ccNumToNumberOfVertices.put(ccNum, ccNumToNumberOfVertices.getOrDefault(ccNum, 0) + 1);
        }

        for (int[] edge: edges) {
            int ccNum = ccNumArray.get(edge[0]); // both vertex having an edge must belong to same CC
            ccNumToNumberOfEdges.put(ccNum, ccNumToNumberOfEdges.getOrDefault(ccNum, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: ccNumToNumberOfVertices.entrySet()) {
            int numVertices = entry.getValue();
            int ccNum = entry.getKey();
            if (numVertices == 1) {
                ans++;
                continue;
            }
            int requiredNoOfEdges = ((numVertices)*(numVertices - 1))/2;
            if (ccNumToNumberOfEdges.get(ccNum) == requiredNoOfEdges) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = {{0,1}, {0,2}, {1,2}, {3,4}};
        int[][] input2 = {{0,1}, {0,2}, {1,2}, {3,4}, {3,5}};
        CountCompleteComponents c = new CountCompleteComponents();
        System.out.println(c.countCompleteComponents(6, input));
        System.out.println(c.countCompleteComponents(6, input2));
    }
}
