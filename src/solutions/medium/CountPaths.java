package solutions.medium;

/**
 * Leetcode 1976: Number of ways to arrive at Destination
 */
public class CountPaths {
    public int countPaths(int n, int[][] roads) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        CountPaths c = new CountPaths();
        System.out.println(c.countPaths(7, roads));
    }
}
