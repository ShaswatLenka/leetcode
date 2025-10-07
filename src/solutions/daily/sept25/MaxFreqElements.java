package solutions.daily.sept25;

import java.util.*;
public class MaxFreqElements {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for (int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            int tempFreq = m.get(num);
            if(tempFreq > maxFreq) maxFreq = tempFreq;
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> e: m.entrySet()) {
            if (e.getValue() == maxFreq) count += e.getValue();
        }

        return count;
    }

    public static void main(String[] args) {
        MaxFreqElements m = new MaxFreqElements();
        int[] inp = {1,2,2,3,1,4};
        System.out.println(m.maxFrequencyElements(inp));
    }
}
