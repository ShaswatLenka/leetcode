package solutions.studyplans.interview150.binarysearch;

/*
 * As long as the leftmost and rightmost elements are greater than their left and right neighbors respectively, we can
 * always prove that the array will have a peak element.
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right=nums.length - 1;
       while (left < right) {
           int mid = left + (right - left) / 2; // to prevent overflow
           if (nums[mid] > nums[mid + 1]) right = mid;
           else left = mid + 1;
       }
       return left;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int[] nums = {1,6,5,4,3,2,1};
        System.out.println(f.findPeakElement(nums));
    }
}
