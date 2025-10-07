package solutions.daily.sept25;
import java.util.*;

/*
120: Triangle [MEDIUM]
topics: DP
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i<triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
           for (int j = 0; j < curr.size(); j++) {
               dp[j] = Math.min(curr.get(j) + dp[j], curr.get(j) + dp[j+1]);
           }
       }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> inp = new ArrayList<>();
        inp.add(new ArrayList<>(Arrays.asList(2)));
        inp.add(new ArrayList<>(Arrays.asList(3,4)));
        inp.add(new ArrayList<>(Arrays.asList(6,5,7)));
        inp.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(t.minimumTotal(inp));
    }
}
