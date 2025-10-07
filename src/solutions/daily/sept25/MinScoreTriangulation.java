package solutions.daily.sept25;


/*
1039: Minimum Score Triangulation of Polygon [MED]
Topics: Dynamic Programming
 */
public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE:
                            dp[i][j], dp[i][k] + values[i]*values[j]*values[k] + dp[k][j]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        MinScoreTriangulation m = new MinScoreTriangulation();
        System.out.println(m.minScoreTriangulation(new int[]{1,2,3}));
        System.out.println(m.minScoreTriangulation(new int[]{3,7,4,5}));
    }
}
