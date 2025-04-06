package solutions.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * Leetcode 317: Shortest Distance from all buildings
 */
public class ShortestDistance {

    // bfs returns the sum of min distances from selected empty land to all buildings
    private int bfs(int[][] grid, int row, int col, int totalHouses) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        visited[row][col] = true;

        int minDistanceSum = 0;
        int housesVisited = 0;
        int steps = 0;
        while(!q.isEmpty() && housesVisited != totalHouses) {
            // this is fundamentally different from what we did in traditional BFS because a single node (cell) here
            // does not have information about its neighbors (like we have in an adj list)
            // this loop is to traverse only one level or step from the source
            for(int i = q.size(); i > 0; i--) {
                int[] currCell = q.poll();
                int currRow = currCell[0];
                int currCol = currCell[1];

                // if current cell is 1 calculate distance
                if (grid[currRow][currCol] == 1) {
                    minDistanceSum += steps;
                    housesVisited++;
                    continue;
                }

                // if current cell is empty, add its neighbors to queue, if not obstacle
                for (int[] dir: dirs) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                       if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                           q.offer(new int[] {nextRow, nextCol});
                           visited[nextRow][nextCol] = true;
                       }
                    }
                }
            }
            steps++;
        }

        // if after running BFS from any empty cell we still did not reach all houses,
        // then its not possible to reach a house from any visited cell as well: so set them to be unreachable
        if (housesVisited != totalHouses) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
           }
            return Integer.MAX_VALUE;
        }
        return minDistanceSum;
    }

    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouses = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalHouses++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (grid[i][j] == 0) {
                   ans = Math.min(ans, bfs(grid, i, j, totalHouses));
                }
            }
        }

        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public static void main(String[] args) {
        ShortestDistance s = new ShortestDistance();
        int[][] inp = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        System.out.println(s.shortestDistance(inp));
    }
}
