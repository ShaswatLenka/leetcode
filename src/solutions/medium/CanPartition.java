package solutions.medium;

import java.util.Arrays;

/**
 * Leetcode 416: Partition Equal Subset Sum
 */

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for (int num: nums) {
            targetSum += num;
        }
        if (targetSum % 2 != 0) return false;
        targetSum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        // base case
        dp[0][0] = true;

        for (int i = 1; i<nums.length; i++) {
            int curr = nums[i-1];
            for (int j = 0; j<targetSum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-curr];
                }
            }
        }


        return dp[nums.length-1][targetSum];
    }

    public static void main(String[] args) {
        CanPartition p = new CanPartition();
        int[] inp = {1,2,5};
        System.out.println(p.canPartition(inp));
    }
}
