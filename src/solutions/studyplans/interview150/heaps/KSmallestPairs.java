package solutions.studyplans.interview150.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** TODO
 * Leetcode 373: Find k pairs with smallest sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>(nums1.length);
        PriorityQueue<Integer> p2 = new PriorityQueue<>(nums2.length);

        for (int i=0; i<nums1.length; i++) {
            p1.add(nums1[i]);
        }

        for (int i=0; i<nums2.length; i++) {
            p2.add(nums2[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i<k; i++) {
            List<Integer> element = new ArrayList<>();
            if (i > nums1.length || i > nums2.length){
                break;
            }
            element.add(p1.poll());
            element.add(p2.poll());
            ans.add(element);
        }
        return ans;
    }
}
