package solutions.medium;
import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<ArrayList<Integer>> subsets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            subsets.add(new ArrayList<>());
        }

        // base case: LDS for first number is itself
        subsets.get(0).add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            List<Integer> maxSubset = new ArrayList<>();
           for (int j = 0; j < i; j++) {
               if ((nums[i] % nums[j] == 0) && maxSubset.size() < subsets.get(j).size()) {
                   maxSubset = subsets.get(j);
               }
           }
            subsets.get(i).addAll(maxSubset);
            subsets.get(i).add(nums[i]);
           if (subsets.get(i).size() == 0) {
               subsets.get(i).add(nums[i]);
           }
        }
        List<Integer> ans = new ArrayList(0);
        for (List<Integer> subset: subsets) {
           if (subset.size() > ans.size()) {
               ans = subset;
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset s = new LargestDivisibleSubset();
        int[] nums = {2,3,4,7,8};
        System.out.println(s.largestDivisibleSubset(nums));
    }
}
