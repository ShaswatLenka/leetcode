package solutions.medium;


import java.util.ArrayList;

// Length of LIS but with O(nlog(n)) complexity

public class LengthOfLIS {

    private int insertionIndex(ArrayList<Integer> arr, int num) {
        // finding the index of the element to replace in the array
        int left = 0, right = arr.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == num) return mid;
            if (arr.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> finalSequence = new ArrayList<>();
        finalSequence.add(nums[0]);
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] < finalSequence.get(finalSequence.size() - 1)) {
                int idx = insertionIndex(finalSequence, nums[i]);
                finalSequence.set(idx, nums[i]);
            }
            else if (nums[i] > finalSequence.get(finalSequence.size() - 1)) {
                finalSequence.add(nums[i]);
            }
        }
        return finalSequence.size();
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] inp = {10,9,2,5,3,7,101,18};
        int[] inp2 = {0,1,0,3,2,3};
//        System.out.println(l.lengthOfLIS(inp));
        System.out.println(l.lengthOfLIS(inp2));
    }
}
