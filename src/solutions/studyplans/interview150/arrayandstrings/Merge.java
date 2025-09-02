package solutions.studyplans.interview150.arrayandstrings;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m+n];
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 + ptr2 < m+n) {
            if (ptr1 == m) {
               for (int i = ptr2; i<n; i++) {
                   sorted[i + ptr1] = nums2[i];
               }
               break;
            }
            if (ptr2 == n) {
                for (int i = ptr1; i<m; i++) {
                    sorted[i + ptr2] = nums1[i];
                }
                break;
            }

            if (nums1[ptr1] < nums2[ptr2]) {
                sorted[ptr1 + ptr2] = nums1[ptr1];
                ptr1++;
            } else {
                sorted[ptr1 + ptr2] = nums2[ptr2];
                ptr2++;
            }
        }
        for (int i = 0; i<m+n; i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        Merge m  = new Merge();
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        m.merge(nums1, 5, nums2, 1);
    }
}
