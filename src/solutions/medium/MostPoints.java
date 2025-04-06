package solutions.medium;

import java.util.Arrays;

/**
 * Leet 2140: Solving Questions with Brainpower
 * https://leetcode.com/problems/solving-questions-with-brainpower/?envType=daily-question&envId=2025-04-01
 *
 * At every step: there are two options - solve it or skip it.
 */

public class MostPoints {
    public long mostPoints(int[][] questions) {

        /*
        Sub-problem:
        dp[i] = Max points from i:n-1, where n = questions.length
        base case dp[n-1] = questions[n-1][0]

        RR:
        dp[i] = max(dp[i], dp[i+1]) // solve it or skip it

         */
       int n = questions.length;
       long[] dp = new long[n];
       dp[n-1] = questions[n-1][0]; // Max (solve it, skip it) will always be solve it cos nothing after skip
       for(int i = n-2; i>=0; i--) {
            int skip = questions[i][1];
            dp[i] = questions[i][0];

            // update dp if we can solve after skipping 'skip' questions
            if (i + skip + 1 < n) {
                dp[i] += dp[i + skip + 1];
            }

            // Max (solve it, skip it)
           dp[i] = Math.max(dp[i], dp[i+1]);
       }
       return dp[0];
    }

    public static void main(String[] args) {
            int[][] inp = {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
            MostPoints p = new MostPoints();
            System.out.println(p.mostPoints(inp));
    }
}
