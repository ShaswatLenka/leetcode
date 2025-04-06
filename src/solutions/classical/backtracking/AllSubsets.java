package solutions.classical.backtracking;
import java.util.*;
/**
 * Classical Backtracking problem: Finding all subsets of a string
 * Leetcode 78: Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

public class AllSubsets {
    List<List<Integer>> allSubsets= new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    private void backtrack(int i, int[] nums) {
       if (i == nums.length) {
           allSubsets.add(new ArrayList<>(subset));
           return;
       }
       // skip i
        backtrack(i+1, nums);

       // choose i
        subset.add(nums[i]);
        backtrack(i+1, nums);
        subset.remove(subset.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return allSubsets;
    }

    public static void main(String[] args) {
        AllSubsets s = new AllSubsets();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = s.subsets(nums);
        for(List<Integer> arr: ans) {
            for (Integer num: arr) {
                System.out.println(num + " ");
            }
            System.out.println();
        }
    }
}
