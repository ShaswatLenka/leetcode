package solutions.easy;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {
    public boolean divideArray(int[] nums) {
      HashMap<Integer, Integer> m = new HashMap<>();
      for (int n: nums) {
          m.put(n, m.getOrDefault(n, 0));
      }

      for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
          if (entry.getValue() %2 != 0) {
              return false;
          }
      }
      return true;
    }
}
