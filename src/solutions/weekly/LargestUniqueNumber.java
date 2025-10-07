package solutions.weekly;

import java.util.HashMap;
import java.util.Map;

/*
   1133: Largest Unique Number [EASY]
 */
public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e: m.entrySet()) {
            if (e.getValue() == 1 && e.getKey() > max) max = e.getKey();
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,3,9,4,9,8,3,1};
        LargestUniqueNumber l = new LargestUniqueNumber();
        System.out.println(l.largestUniqueNumber(nums));
    }
}
