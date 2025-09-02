package solutions.hard;
/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0.00000;
        int length = nums1.length + nums2.length;
        int[] arr = new int[length];

        int i=0, j=0;
        for (int k=0; k<length; k++) {
            if (i == nums1.length && j < nums2.length) {
               while (j < nums2.length) {
                   arr[i+j] = nums2[j];
                   j++;
               }
               break;
            }
            if (j == nums2.length  && i < nums1.length) {
                while (i < nums1.length) {
                    arr[i+j] = nums1[i];
                    i++;
                }
                break;
            }
            if (nums1[i] <= nums2[j]) {
                arr[i+j] = nums1[i];
                i++;
            } else {
                arr[i+j] = nums2[j];
                j++;
            }
        }
        if (length % 2 == 0) {
            ans = (double)(arr[length/2] + arr[length/2 - 1])/2;
        } else {
            ans = arr[length/2];
        }
        return ans;
    }

    public static void main(String[] args) {
        MedianSortedArrays m = new MedianSortedArrays();
        int[] nums1 = {}, nums2 = {3,4};
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
