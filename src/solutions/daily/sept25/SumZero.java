package solutions.daily.sept25;

import java.util.Arrays;

public class SumZero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 1; i<n; i++) {
                ans[i-1] = i;
                sum += i;
        }
        ans[n-1] = -1*sum;
        return ans;
    }

    public static void main(String[] args) {
       SumZero s = new SumZero();
        System.out.println(Arrays.toString(s.sumZero(5)));
        System.out.println(Arrays.toString(s.sumZero(4)));
    }
}
