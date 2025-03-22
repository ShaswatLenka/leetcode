package solutions.studyplans.interview150;

import java.util.*;

/**
 * Leetcode 909: Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/editorial/?envType=study-plan-v2&envId=top-interview-150
 */

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        AbstractMap.SimpleEntry<Integer, Integer>[] cells = new AbstractMap.SimpleEntry[n*n + 1];
        int label = 1; // label for a single cell
        Integer[] columns = new Integer[n];
        for(int i = 0; i<n; i++) {
            columns[i] = i;
        }

        // create the board using cells array
        for (int row = n-1; row >= 0; row--) {
            for (int column: columns) {
                cells[label++] = new AbstractMap.SimpleEntry<>(row, column);
            }
            // reverse the columns each time to accommodate for Boustrophedon style
            Collections.reverse(Arrays.asList(columns));
        }

        int [] dist = new int[n*n + 1]; Arrays.fill(dist, -1); // saves the answer for shortest path to all cells from 1

        // BFS
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0; // because we are starting from 1
        q.add(1);
        while(!q.isEmpty()) {
            Integer currNode = q.remove();
            for(int nbr = currNode + 1; nbr <= Math.min(n*n, currNode + 6); nbr++) {
                int row = cells[nbr].getKey(), column = cells[nbr].getValue();
                int destination = board[row][column] == -1 ? nbr : board[row][column];
                if (dist[destination] == -1) {
                    dist[destination] = dist[currNode] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n*n];
    }

    public static void main(String[] args) {
        SnakesAndLadders s = new SnakesAndLadders();
        int[][] arr = {{-1, -1}, {-1, 3}};
        System.out.println(s.snakesAndLadders(arr));
    }
}
