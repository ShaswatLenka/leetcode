package solutions.medium;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */

import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i<nums.length && nums[i] <=0 ; i++) {
            if (i==0 || nums[i-1] != nums[i]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < 0) {
                        ++lo;
                    } else if (sum > 0) {
                        --hi;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                        while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        int[] inp = {-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(inp));
    }
}
