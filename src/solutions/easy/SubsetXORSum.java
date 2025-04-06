package solutions.easy;

public class SubsetXORSum {
    private int backtrack(int i, int[] nums, int currXORSum) {
       if (i == nums.length) {
            return currXORSum;
       }

       // skip nums[i]
        int leftXORSum = backtrack(i+1, nums, currXORSum);

       // include nums[i]
        int rightXORSum = backtrack(i+1, nums, currXORSum^nums[i]);

        return leftXORSum + rightXORSum;
    }

    public int subsetXORSum(int[] nums) {
        return backtrack(0, nums, 0);
    }

    public static void main(String[] args) {
        SubsetXORSum s = new SubsetXORSum();
        int[] nums = {5,1,6};
        System.out.println(s.subsetXORSum(nums));
    }
}
