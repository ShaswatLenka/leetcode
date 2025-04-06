package solutions.easy;

/**
 * You are given a 0-indexed integer array nums.
 *
 * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
 *
 * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
 */

public class MaximumTripletValue {
    public long maximumTripletValue(int[] nums) {
       // for any fixed j, the maximal value would always be the max value from i in [0, j) and
        // max value of k in (j, n]
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int j = 1; j < n-1; j++) {
           leftMax[j] = Math.max(leftMax[j-1], nums[j-1]); // for max value of i
            rightMax[n-j-1] = Math.max(rightMax[n-j], nums[n-j]); // for max value of k
        }

        long ans = 0;
        for (int j = 1; j < n-1; j++) {
           ans = Math.max(ans, (long)(leftMax[j] - nums[j])* rightMax[j]);
        }
        if (ans < 0) return 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] inp = {12, 6, 1, 2, 7};
        MaximumTripletValue m = new MaximumTripletValue();
        System.out.println(m.maximumTripletValue(inp));
    }
}
