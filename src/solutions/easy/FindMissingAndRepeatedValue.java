package solutions.easy;

import java.util.Arrays;

public class FindMissingAndRepeatedValue {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int len = grid.length;
        long n = len*len;
        long sumUptoN = (n *(n+1))/2;
        long squaredSumUptoN = ((n)*(n+1)*(2*n+1))/6;
        long currSum = 0;
        long currSquaredSum = 0;
        for(int i = 0; i<len; i++){
            for (int j = 0; j<len; j++){
                currSum += grid[i][j];
                currSquaredSum += Math.pow(grid[i][j], 2);
            }
        }
        long A = currSum - sumUptoN;
        long B = currSquaredSum - squaredSumUptoN;
        int y  =(int) (A + B/A)/2;
        int x = (int) (y - A);
        ans[0] = y; ans[1] = x;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3},
                {2,2}
        };
        FindMissingAndRepeatedValue solution = new FindMissingAndRepeatedValue();
        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(grid)));
    }
}
