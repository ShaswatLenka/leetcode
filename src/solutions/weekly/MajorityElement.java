package solutions.weekly;


/**
 * 1150: Check if a number is a majority element in a sorted array
 */

public class MajorityElement {

    private int leftElementIdx(int[] nums, int target) {
        int l = -1, r = nums.length;

        while (r-l > 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid;
            else r = mid;
        }
        return l;
    }

    private int rightElementIdx(int[] nums, int target) {
        int l = -1, r = nums.length;

        while(r - l > 1) {
           int mid = l + (r-l)/2;
           if (nums[mid] <= target) l = mid;
           else r = mid;
        }
        return r;
    }


    public boolean isMajorityElement(int[] nums, int target) {
        int leftIdx = leftElementIdx(nums, target);
        int rightIdx = rightElementIdx(nums, target);
        if (rightIdx - leftIdx - 1 > nums.length/2) return true;
        return false;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] inp = {5,5};
        System.out.println(m.isMajorityElement(inp, 5));
    }
}
