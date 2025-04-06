package solutions.studyplans.interview150.arrayandstrings;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 1 && nums1[0] != 0) return;
        if (nums2.length == 0) return;

        for(int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        int ptr1 = 0;
        int ptr2 = m;
        while(ptr1 < ptr2 && ptr1<m+n && ptr2<m+n) {
            if (nums1[ptr1] > nums1[ptr2]) {
                int temp = nums1[ptr1];
                nums1[ptr1] = nums1[ptr2];
                nums1[ptr2] = temp;
                ptr2++;
            }
            ptr1++;
        }
    }

    public static void main(String[] args) {
        Merge m  = new Merge();
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        m.merge(nums1, 5, nums2, 1);
    }
}
