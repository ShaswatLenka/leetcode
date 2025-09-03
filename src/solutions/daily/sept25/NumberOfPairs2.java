package solutions.daily.sept25;

/*
3027: Number of ways to place people 2
(an extension of NumberOfPairs (leetcode 3025))
 */

import java.util.Arrays;

public class NumberOfPairs2 {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // if they have same x co-ords then sort by decreasing y, else sort by increasing x
        for (int i=0; i<points.length; i++) {
            int[] pointA = points[i];
            int xMin = pointA[0] - 1;
            int xMax = Integer.MAX_VALUE;
            int yMin = Integer.MIN_VALUE;
            int yMax = pointA[1] + 1;

            for (int j = i+1; j<points.length; j++) {
                int[] pointB = points[j];
                if (pointB[0] > xMin && pointB[0] < xMax && pointB[1] < yMax && pointB[1] > yMin) {
                    ans++;
                    xMin = pointB[0];
                    yMin = pointB[1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfPairs n = new NumberOfPairs();
        int[][] input1 = {{1,1}, {2,2}, {3,3}};
        int[][] input2 = {{6,2}, {4,4}, {2,6}};
        int[][] input3 = {{3,1}, {1,3}, {1,1}};
        System.out.println(n.numberOfPairs(input1));
        System.out.println(n.numberOfPairs(input2));
        System.out.println(n.numberOfPairs(input3));
    }
}
