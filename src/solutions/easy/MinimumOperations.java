package solutions.easy;
import java.util.*;
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        int[] repeated = new int[100];
        Map<Integer, Integer> m = new HashMap<>();
        for (int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int repeatedSum = 0;
        int repeatedTargetValue = 0;
        for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
           if (entry.getValue() > 1) {
               repeated[entry.getKey()] = entry.getValue();
               repeatedSum += entry.getValue();
               repeatedTargetValue++;
           }
        }

        if (repeatedSum == repeatedTargetValue) return 0;

        int ans = 0;
        for (int i = 0; i<nums.length - 3; i+=3) {
            if (repeated[nums[i]] > 1) repeatedSum--;
            if (repeated[nums[i+1]] > 1) repeatedSum--;
            if (repeated[nums[i+2]] > 1) repeatedSum--;
            ans++;
            if (repeatedSum <= repeatedTargetValue) return ans;
            if (i+3 >= nums.length) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOperations m = new MinimumOperations();
        System.out.println(m.minimumOperations(new int[] {10, 12, 12, 6, 6}));
    }
}
