package solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountComponents {

    private void explore(int src, Map<Integer, ArrayList<Integer>> adjList, Boolean[] visited) {
        visited[src] = true;
        for (Integer nbr: adjList.get(src)) {
            if (!visited[nbr]) {
                explore(nbr, adjList, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i<n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] e: edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        int CCNum = 0;

        for (int i = 0; i<n; i++) {
           if (!visited[i]){
               CCNum++;
              explore(i, adjList, visited);
           }
        }

        return CCNum;
    }

    public static void main(String[] args) {
        CountComponents c = new CountComponents();
        int n=4; int[][] edges = {{2,3}, {1,2}, {1,3}};
        System.out.println(c.countComponents(n, edges));
    }
}
